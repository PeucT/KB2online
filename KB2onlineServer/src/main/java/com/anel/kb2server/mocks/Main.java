package com.anel.kb2server.mocks;

import com.anel.kb2server.entities.TerrainObject;
import com.anel.kb2server.entities.WorldMap;
import com.anel.kb2server.entities.enums.TerrainTypeEn;
import com.anel.kb2server.generators.GameWorldGenerator;

/**
 * Created by ArchMage on 30.05.18.
 */
public class Main {
    public static void main(String[] args){
        GameWorldGenerator worldGenerator = new GameWorldGenerator();
        WorldMap map = worldGenerator.getStage1();
        mapShower(map);
    }

    public static void mapShower(WorldMap map){
        if (map.getMap()[0][0] != null) {
            for (int i = 0; i < map.getMap().length; i++) {
                for (int j = 0; j < map.getMap()[0].length; j++){
                    if (!((map.getMap()[i][j]).getObjectType() == TerrainTypeEn.GLADE.ordinal() )) {
                        System.out.print(map.getMap()[i][j].getObjectType());
                    } else {
                        System.out.print("      ");
                    }
                }
                System.out.println();
            }
        }else {
            System.out.println(map.toString());
        }
    }
}
