package com.anel.kb2client.entities;

/**
 * Created by ArchMage on 31.05.18.
 */
public class WorldMap {
    private TerrainObject[][] map;

    public TerrainObject[][] getMap() {
        return map;
    }

    public void setMap(TerrainObject[][] map) {
        this.map = map;
    }
}
