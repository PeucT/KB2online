package com.anel.kb2server.entities;

import static com.anel.kb2server.util.IdGenerator.getNextId;

/**
 * Created by ArchMage on 29.05.18.
 */
public abstract class AbstractMapObject implements MapObject{
    private int id;
    private int objectType;
    private Integer x;
    private Integer y;


    public AbstractMapObject(Integer id, int objectType, Integer x, Integer y) {
        this.id = id;
        this.objectType = objectType;
        this.x = x;
        this.y = y;
    }

    public AbstractMapObject(int objectType, Integer x, Integer y) {
        this.id = getNextId();
        this.objectType = objectType;
        this.x = x;
        this.y = y;
    }

    public AbstractMapObject(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
