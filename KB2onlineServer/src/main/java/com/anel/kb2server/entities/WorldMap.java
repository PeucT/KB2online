package com.anel.kb2server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ArchMage on 29.05.18.
 */
public class WorldMap {
    private AbstractMapObject[][] map;

    @JsonIgnore
    private int stageId;

    public WorldMap(Integer width, Integer height) {
        this.map = new AbstractMapObject[height][width];
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public AbstractMapObject[][] getMap() {
        return map;
    }

    public void setMap(AbstractMapObject[][] map) {
        this.map = map;
    }
}
