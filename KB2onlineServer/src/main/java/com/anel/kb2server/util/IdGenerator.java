package com.anel.kb2server.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ArchMage on 05.06.18.
 */
public class IdGenerator {
    private static AtomicInteger idKeeper = new AtomicInteger(1);

    public static int getNextId(){
        return idKeeper.getAndIncrement();
    }
}
