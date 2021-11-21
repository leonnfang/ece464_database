package com.ece464.recipewizard.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ece464.recipewizard.Service.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class DataQueryApi {

    private final RecipeRepository repository;

    public DataQueryApi(RecipeRepository repository) {
        this.repository = repository;
    }
    // query by name
    // query by ingredients
    // top recommendation ?? additional features

    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }

    /**
     *
     * @param names
     * the names users are interested in searching for
     * @return
     * all matched recipes will be returned
     */

    @RequestMapping(path = "/search/recipe/{names}")
    public JSONArray getRecipeByNames(@PathVariable String names){
//        List<Recipe> recipes = repository.findByName(names.get(0));
//        return new JSONArray(Collections.singletonList(recipes));
        return new JSONArray();
    }

    /**
     *
     * @return
     * the list of all ingredients will be returned
     */
    @RequestMapping(path = "/info/list_ingredients")
    public JSONArray getIngredientList(){
        return new JSONArray();
    }



    /**
     *
     * @param names the list of ingredients
     * @return matched recipes
     */
    @RequestMapping(path = "/search/ingredient")
    public JSONArray getRecipeByIngredients(@RequestHeader List<String> names){
        repository.findByIngredient(Collections.singletonList(names));
        return new JSONArray();
    }

    /**
     *
     * @return
     * all recommended recipe will be returned as Json array
     */
    @RequestMapping(path = "/search/recommend")
    public JSONArray recommendRecipe(){
        // return the recommended recipes
        return new JSONArray();
    }

    /**
     *
     * @param recipeInfo
     * the recipe users are interested in loading into the database
     * @return
     * status will be returned, to see the recipe has been updated or not
     */
    @RequestMapping(path = "/update/recipe")
    public boolean insertRecipe(JSONObject recipeInfo){
        // TODO insert the recipe info to the database
        return true;
    }
}
