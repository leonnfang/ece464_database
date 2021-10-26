package com.ece464.recipewizard.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataQueryApi {

    // query by name
    // query by ingredients
    // top recommendation ?? additional features

    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }
}
