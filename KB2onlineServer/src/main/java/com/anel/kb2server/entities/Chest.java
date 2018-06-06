package com.anel.kb2server.entities;

import com.anel.kb2server.util.PropHelper;

/**
 * Created by ArchMage on 05.06.18.
 */
public class Chest extends AbstractMapObject {
    private static final int mapObjectChestCode = Integer.valueOf(PropHelper.getByPropKey("OBJECT_TYPE_CHEST"));

    private int resType;
    private int amount;

    public Chest(Integer x, Integer y, int resType, int amount) {
        super(mapObjectChestCode, x, y);
        this.resType = resType;
        this.amount = amount;
    }

    public Chest(Integer x, Integer y) {
        super(x, y);
    }

    public int getResType() {
        return resType;
    }

    public void setResType(int resType) {
        this.resType = resType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
