package com.ece464.recipewizard.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping(path = "/search/recipe/{names}")
    public JSONArray getRecipeByNames(@PathVariable List<String> names){
        // search by recipe names
//        return MysqlManager.get(names);
//        return null;
        return new JSONArray();
    }

    @RequestMapping(path = "/search/ingredient/{names}")
    public JSONArray getRecipeByIngredients(@PathVariable List<String> names){
        // search by ingredient
//        return MysqlManager.get(names);
//        return null;
        return new JSONArray();
    }

    @RequestMapping(path = "/search/recommend")
    public JSONArray recommendRecipe(){
        // return the recommended recipes
        return new JSONArray();
    }

    @RequestMapping(path = "/update/recipe")
    public boolean insertRecipe(JSONObject recipeInfo){
        // TODO insert the recipe info to the database
        return true;
    }
}
