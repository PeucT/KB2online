package com.anel.kb2server.generators;

import com.anel.kb2server.entities.Barracks;
import com.anel.kb2server.entities.Chest;
import com.anel.kb2server.entities.TerrainObject;
import com.anel.kb2server.entities.WorldMap;
import com.anel.kb2server.entities.enums.TerrainTypeEn;
import com.anel.kb2server.util.PropHelper;


import java.util.Random;

import static com.anel.kb2server.util.IdGenerator.getNextId;

/**
 * Created by ArchMage on 29.05.18.
 */
public class TerrainGenerator {
    private static final int RIVER_WIDTH = 3;
    private static final int RESOURCES_TYPES_QUANTITY = 2;
    private static final int RESOURCES_BASE_AMOUNT = 1000;

    private static final int terrainObjectIndex = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_TERRAIN"));
    private static final int chestObjectIndex = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_CHEST"));
    private static final int barracksObjectIndex = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_BARRACKS"));

    /*private static TerrainType water = new TerrainType(1, WATER, Float.valueOf(PropHelper.getByPropKey("WATER")));
    private static TerrainType glade = new TerrainType(2, GLADE, Float.valueOf(PropHelper.getByPropKey("GLADE")));
    private static TerrainType forest = new TerrainType(3, FOREST, Float.valueOf(PropHelper.getByPropKey("FOREST")));
    private static TerrainType cliffs = new TerrainType(4, CLIFFS, Float.valueOf(PropHelper.getByPropKey("CLIFFS")));
    private static TerrainType desert = new TerrainType(5, DESERT, Float.valueOf(PropHelper.getByPropKey("DESERT")));*/
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

        generateBarracks(map, 1);
        generateChests(map, 0.02d);

        generateNonBasicFrequencyBaseObjects(map, 0.3d, terrainObjectIndex, TerrainTypeEn.FOREST.ordinal());
        generateNonBasicFrequencyBaseObjects(map, 0.2d, terrainObjectIndex, TerrainTypeEn.CLIFFS.ordinal());
    }

    private void initialFill(WorldMap map, Integer x, Integer y){
        for (int i = 0; i < y; i++){
            for (int j = 0; j < x; j++ ){
                if (j < 2 || j >= x - 2) {
                    map.getMap()[i][j] = new TerrainObject(j , i, TerrainTypeEn.WATER.ordinal());
                } else {
                    if (i < 2 || i >= y -2) {
                        map.getMap()[i][j] = new TerrainObject(j , i, TerrainTypeEn.WATER.ordinal());
                    } else {
                        map.getMap()[i][j] = new TerrainObject(j , i, TerrainTypeEn.GLADE.ordinal());
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
                    map.getMap()[y][x + i] = new TerrainObject(y, x + i, TerrainTypeEn.WATER.ordinal());
                } else {
                    map.getMap()[y + i][x] = new TerrainObject(y, x, TerrainTypeEn.WATER.ordinal());
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

    private void generateAdditionalTerrainObjects(WorldMap map, Double frequency, int terrainType) {
        /*for (int i = 2; i < worldHeight - 2; i++){
            for (int j = 2; j < worldWidth - 2; j++){
                if (Math.random() < frequency) {
                    if (((TerrainObject)map.getMap()[i][j]).getType() == TerrainTypeEn.GLADE.ordinal()) {
                        map.getMap()[i][j] = new TerrainObject(j, i, terrainType);
                    }
                }
            }
        }*/
        generateNonBasicFrequencyBaseObjects(map, frequency, terrainObjectIndex, terrainType);
    }

    private void generateNonBasicFrequencyBaseObjects(WorldMap map, Double frequency, int objectsType, Integer additionalType) {
        for (int i = 2; i < worldHeight - 2; i++){
            for (int j = 2; j < worldWidth - 2; j++){
                if (Math.random() < frequency) {
                    if ((map.getMap()[i][j]).getObjectType() == terrainObjectIndex &&
                            ((TerrainObject)(map.getMap()[i][j])).getType() == TerrainTypeEn.GLADE.ordinal()) {
                        if (objectsType == terrainObjectIndex) {
                            map.getMap()[i][j] = new TerrainObject(j, i, additionalType);
                        } else if (objectsType == chestObjectIndex) {
                            map.getMap()[i][j] =
                                    new Chest(  j,
                                                i,
                                                1 + random.nextInt(RESOURCES_TYPES_QUANTITY - 1),
                                                1 + random.nextInt(RESOURCES_BASE_AMOUNT));
                        }
                    }
                }
            }
        }
    }

    private void generateChests(WorldMap map, Double density){
        generateNonBasicFrequencyBaseObjects(map, density, chestObjectIndex, null);
    }

    private void generateBarracks(WorldMap map, int creatureGroup){
        int barracksAmount = Integer.valueOf(PropHelper.getByPropKey("BARRACKS_AMOUNT"));

        generateNonBasicStaticCountableObjects(map, barracksObjectIndex, barracksAmount, creatureGroup);
    }

    private void generateNonBasicStaticCountableObjects(WorldMap map, int objType, int iterationCount, int additionalAttr){
        int count = 0;
        while (count < iterationCount) {
            int i = 2 + random.nextInt(worldHeight - 2);
            int j = 2 + random.nextInt(worldWidth - 2);
            if (map.getMap()[i][j].getObjectType() == terrainObjectIndex) {
                {
                    if (((TerrainObject)map.getMap()[i][j]).getType() == TerrainTypeEn.GLADE.ordinal()) {
                        map.getMap()[i][j] = new Barracks(j,i, additionalAttr);
                        count++;
                    }
                }
            }
        }
    }
}
