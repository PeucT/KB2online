package com.anel.kb2server.controllers;

import com.anel.kb2server.entities.AbstractMapObject;
import com.anel.kb2server.entities.WorldMap;
import com.anel.kb2server.generators.GameWorldGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArchMage on 31.05.18.
 */
@RestController
@RequestMapping(MainServiceController.REST_URL)
public class MainServiceController {
    static final String REST_URL = "/rest/v1/land";

    @Autowired
    GameWorldGenerator gameWorldGenerator;

    @GetMapping(/*value = "/results",*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public WorldMap getFullMap() {
        return gameWorldGenerator.getStage1();
    }
}
