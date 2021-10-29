package com.ece464.recipewizard.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ece464.recipewizard.Model.Recipe;
import com.ece464.recipewizard.Service.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class DataQueryApi {

    @Autowired
    private RecipeRepository repository;
    // query by name
    // query by ingredients
    // top recommendation ?? additional features

    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }

    @RequestMapping(path = "/search/recipe/{names}")
    public JSONArray getRecipeByNames(@PathVariable List<String> names){
        List<Recipe> recipes = repository.findByName(names.get(0));
        return new JSONArray(Collections.singletonList(recipes));
    }

    @RequestMapping(path = "/search/ingredient/{names}")
    public JSONArray getRecipeByIngredients(@PathVariable List<String> names){
        repository.findByIngredient(Collections.singletonList(names));
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
