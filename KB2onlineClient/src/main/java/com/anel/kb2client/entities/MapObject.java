package com.anel.kb2client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ArchMage on 06.06.18.
 */
public class MapObject {
    private int id;

    @JsonProperty("objectType")
    private int mapObjectType;
    private int x;
    private int y;

    @JsonProperty("type")
    private int terrainType;
    private int resType;
    private int amount;

    @JsonProperty("creature")
    @JsonIgnore
    private Creature creature;

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMapObjectType() {
        return mapObjectType;
    }

    public void setMapObjectType(int mapObjectType) {
        this.mapObjectType = mapObjectType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(int terrainType) {
        this.terrainType = terrainType;
    }

    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}
