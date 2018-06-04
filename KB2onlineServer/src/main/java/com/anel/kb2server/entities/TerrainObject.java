package com.anel.kb2server.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ArchMage on 29.05.18.
 */
public class TerrainObject extends AbstractMapObject {

    private TerrainType type;

    public TerrainObject(Integer x, Integer y, TerrainType type) {
        super(x, y);
        this.type = type;
    }

    public TerrainType getType() {
        return type;
    }

    public void setType(TerrainType type) {
        this.type = type;
    }
}
