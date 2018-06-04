package com.anel.kb2client.controllers;

import com.anel.kb2client.entities.WorldMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by ArchMage on 31.05.18.
 */

@Controller
public class MainGameController {

    @RequestMapping(value = "/land")
    public @ResponseBody ModelAndView getFullLand(){
        ModelAndView modelAndView = new ModelAndView();
        /*modelAndView.addObject("map", );*/

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject("http://localhost:8888/rest/v1/land", String.class);


        ObjectMapper mapper = new ObjectMapper();
        WorldMap map = null;
        try {
            map = mapper.readValue(result, WorldMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("map", map);

        return modelAndView;
    }
}
