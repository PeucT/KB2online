package com.anel.kb2server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ArchMage on 29.05.18.
 */
public class WorldMap {
    private MapObject[][] map;

    @JsonIgnore
    private int stageId;

    public WorldMap(Integer width, Integer height) {
        this.map = new MapObject[height][width];
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public MapObject[][] getMap() {
        return map;
    }

    public void setMap(MapObject[][] map) {
        this.map = map;
    }
}
