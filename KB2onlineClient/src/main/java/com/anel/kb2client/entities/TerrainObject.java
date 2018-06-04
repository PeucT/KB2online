package com.anel.kb2client.entities;

/**
 * Created by ArchMage on 31.05.18.
 */
public class TerrainObject {
    private int id;
    private int x;
    private int y;
    private TerrainType type;

    public TerrainObject() {
    }

    public TerrainObject(int x, int y, TerrainType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TerrainType getType() {
        return type;
    }

    public void setType(TerrainType type) {
        this.type = type;
    }
}
