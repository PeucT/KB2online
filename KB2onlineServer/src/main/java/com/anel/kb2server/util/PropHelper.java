package com.anel.kb2server.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ArchMage on 30.05.18.
 */

public class PropHelper {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/game_settings/settings.properties";
    public static Properties prop = new Properties();

    static{
        try (FileInputStream file = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(file);
        }catch (IOException e) {
            System.out.println("no prop file");
        }
    }

    /*public static TerrainType getTerrainAttribute(String terrain){
        return prop.getProperty(terrain);
    }*/

    public static String getByPropKey(String key) {
        /*Properties prop = new Properties();

        try (FileInputStream file = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(file);
        }catch (IOException e) {
            System.out.println("no prop file");
        }
        System.out.println("hello");*/
        return prop.getProperty(key);

    }
}
