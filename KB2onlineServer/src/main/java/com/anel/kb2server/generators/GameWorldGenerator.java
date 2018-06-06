package com.anel.kb2server.generators;

import com.anel.kb2server.entities.WorldMap;
import com.anel.kb2server.util.PropHelper;
import org.springframework.stereotype.Service;

/**
 * Created by ArchMage on 29.05.18.
 */
@Service
public class GameWorldGenerator {
    private static int worldWidth = Integer.valueOf(PropHelper.getByPropKey("GAME_WORLD_WIDTH"));
    private static int worldHeight = Integer.valueOf(PropHelper.getByPropKey("GAME_WORLD_HEIGHT"));
    private TerrainGenerator terrainGenerator;

    public GameWorldGenerator() {
        this.terrainGenerator = new TerrainGenerator(worldWidth, worldHeight);
    }


    public WorldMap getStage1(){
        WorldMap map = new WorldMap(worldWidth, worldHeight);
        terrainGenerator.generateStage1Terrain(map);

        return map;
    }


}
