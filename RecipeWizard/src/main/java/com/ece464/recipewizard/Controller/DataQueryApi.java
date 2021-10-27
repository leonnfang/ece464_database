package com.ece464.recipewizard.Controller;


import com.ece464.recipewizard.Model.Recipe;
import com.ece464.recipewizard.Service.MysqlManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataQueryApi {

    // query by name
    // query by ingredients
    // top recommendation ?? additional features

    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }

    @RequestMapping(path = "/search/{names}")
    public List<Recipe> getRecipeByIngredients(@PathVariable List<String> names){
        return MysqlManager.get(names);
//        return null;
    }
}
