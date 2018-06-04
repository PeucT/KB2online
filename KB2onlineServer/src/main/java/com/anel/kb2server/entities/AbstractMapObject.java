package com.anel.kb2server.entities;

/**
 * Created by ArchMage on 29.05.18.
 */
public abstract class AbstractMapObject extends AbstractEntity{
    private Integer x;
    private Integer y;

    public AbstractMapObject(Integer id, Integer x, Integer y) {
        super(id);
        this.x = x;
        this.y = y;
    }

    public AbstractMapObject(Integer x, Integer y) {
        super(null);
        this.x = x;
        this.y = y;
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
}
