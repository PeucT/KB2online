package com.anel.kb2server.entities;


import com.anel.kb2server.util.PropHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ArchMage on 29.05.18.
 */
public class TerrainObject extends AbstractMapObject{
    private static final int mapObjectTerrainCode = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_TERRAIN"));

    private int type;

    @JsonIgnore
    private Float speedMultiplier = 1f;

    public TerrainObject(Integer x, Integer y, int type) {
        super(mapObjectTerrainCode, x, y);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
