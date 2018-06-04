package com.anel.kb2server.generators;

import com.anel.kb2server.entities.TerrainObject;
import com.anel.kb2server.entities.TerrainType;
import com.anel.kb2server.entities.WorldMap;
import com.anel.kb2server.entities.enums.TerrainTypeEn;
import com.anel.kb2server.util.PropHelper;

import java.util.Random;

import static com.anel.kb2server.entities.enums.TerrainTypeEn.*;
import static com.anel.kb2server.entities.enums.TerrainTypeEn.DESERT;

/**
 * Created by ArchMage on 29.05.18.
 */
public class TerrainGenerator {
    private static final int RIVER_WIDTH = 3;

    private static TerrainType water = new TerrainType(1, WATER, Float.valueOf(PropHelper.getByPropKey("WATER")));
    private static TerrainType glade = new TerrainType(2, GLADE, Float.valueOf(PropHelper.getByPropKey("GLADE")));
    private static TerrainType forest = new TerrainType(3, FOREST, Float.valueOf(PropHelper.getByPropKey("FOREST")));
    private static TerrainType cliffs = new TerrainType(4, CLIFFS, Float.valueOf(PropHelper.getByPropKey("CLIFFS")));
    private static TerrainType desert = new TerrainType(5, DESERT, Float.valueOf(PropHelper.getByPropKey("DESERT")));
    private int worldWidth;
    private int worldHeight;
    private Random random = new Random();


    public TerrainGenerator(int worldWidth, int worldHeight) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
    }

    /*public void generateRandomTerrain(WorldMap map){
        initialFill(map, worldWidth, worldHeight);
    }*/

    public void generateStage1Terrain(WorldMap map){
        initialFill(map, worldWidth, worldHeight);
        generateRiver(map, 10);
        generateRiver(map, 15);
        generateAdditionalTerrain(map, 0.3d, forest);
        generateAdditionalTerrain(map, 0.2d, cliffs);
    }

    private void initialFill(WorldMap map, Integer x, Integer y){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++ ){
                if (j < 2 || j >= x - 2) {
                    map.getMap()[i][j] = new TerrainObject(j , i, water);
                } else {
                    if (i < 2 || i >= y -2) {
                        map.getMap()[i][j] = new TerrainObject(j , i, water);
                    } else {
                        map.getMap()[i][j] = new TerrainObject(j , i, glade);
                    }
                }
            }
        }
    }

    private void generateRiver(WorldMap map, int length){
        int sideIndex = random.nextInt(4);
        int start = 0;
        switch (sideIndex) {
            case 0:
                start = 2 + random.nextInt( worldWidth - 2 - RIVER_WIDTH);
                drawRiver(map, start, 2, sideIndex, length);
                break;
            case 1:
                start = 2 + random.nextInt( worldHeight - 2 - RIVER_WIDTH);
                drawRiver(map, 2, start, sideIndex, length);
                break;
            case 2:
                start = 2 + random.nextInt( worldWidth - 2 - RIVER_WIDTH);
                drawRiver(map, start, worldHeight - 2, sideIndex, length);
                break;
            case 3:
                start = 2 + random.nextInt( worldHeight - 2 - RIVER_WIDTH);
                drawRiver(map, worldWidth - 2,  start, sideIndex, length);
                break;
        }
        drawRiver(map, start, 2, sideIndex, length);
    }

    private void drawRiver(WorldMap map, int x, int y, int sideIndex, int length){
        int step = 0;
        while (step < length){
            step++;
            int riverCurrentWidth = 1 + random.nextInt(RIVER_WIDTH - 1);
            for (int i = 0; i < riverCurrentWidth; i++){
                if (sideIndex == 0 || sideIndex == 2) {
                    map.getMap()[y][x + i] = new TerrainObject(y, x + i, water);
                } else {
                    map.getMap()[y + i][x] = new TerrainObject(y, x, water);
                }
            }
            int delta = random.nextInt(riverCurrentWidth + 2);
            switch (sideIndex) {
                case 0:
                    x = x + delta - 1;
                    y = y + 1;
                    break;
                case 1:
                    x = x - 1;
                    y = y + delta - 1;
                    break;
                case 2:
                    x = x + delta - 1;
                    y = y - 1;
                case 3:
                    x = x + 1;
                    y = y + delta - 1;
                    break;
            }

            x = checkAndAdjustBorders(x, worldWidth);
            y = checkAndAdjustBorders(y, worldHeight);

        }
    }

    private int checkAndAdjustBorders(int param, int maxParam){
        if (param < 2) {
            param = 2;
        }else {
            if ( param > maxParam - 2 - RIVER_WIDTH ) { param = maxParam - 2 - RIVER_WIDTH; }
        }
        return param;
    }

    private void generateAdditionalTerrain(WorldMap map, Double frequency, TerrainType terrainType) {
        for (int i = 2; i < worldHeight - 2; i++){
            for (int j = 2; j < worldWidth - 2; j++){
                if (Math.random() < frequency) {
                    if (((TerrainObject)map.getMap()[i][j]).getType().getName().equals(TerrainTypeEn.GLADE)) {
                        map.getMap()[i][j] = new TerrainObject(j, i, terrainType);
                    }
                }
            }
        }
    }
}
