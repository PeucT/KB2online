package com.anel.kb2server.entities;

import com.anel.kb2server.entities.enums.TerrainTypeEn;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ArchMage on 30.05.18.
 */


public class TerrainType extends AbstractEntity {

    @JsonIgnore
    private TerrainTypeEn name;

    @JsonIgnore
    private Float speedMultiplier;

    public TerrainType(TerrainTypeEn name, Float speedMultiplier) {
        this.name = name;
        this.speedMultiplier = speedMultiplier;
    }

    public TerrainType(Integer id, TerrainTypeEn name, Float speedMultiplier) {
        super(id);
        this.name = name;
        this.speedMultiplier = speedMultiplier;
    }

    public TerrainTypeEn getName() {
        return name;
    }

    public void setName(TerrainTypeEn name) {
        this.name = name;
    }

    public Float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(Float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }
}
