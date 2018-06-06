package com.anel.kb2server.entities;

import com.anel.kb2server.util.PropHelper;

/**
 * Created by ArchMage on 05.06.18.
 */
public class Barracks extends AbstractMapObject {
    private final Creature creature;
    private int amount;

    private static final int mapObjectBarracksCode = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_BARRACKS"));

    public Barracks(int x, int y, int group){
        super(mapObjectBarracksCode, x,y);
        creature = new Creature();
    }

    public Creature getCreature() {
        return creature;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
