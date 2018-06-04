package com.anel.kb2server.entities;

/**
 * Created by ArchMage on 29.05.18.
 */
public class PlayerHero extends AbstractMapObject {

    public PlayerHero(Integer id, Integer x, Integer y) {
        super(id, x, y);
    }

    public PlayerHero(Integer x, Integer y) {
        super(x, y);
    }
}
