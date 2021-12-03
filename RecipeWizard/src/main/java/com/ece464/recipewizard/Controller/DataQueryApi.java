package com.ece464.recipewizard.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ece464.recipewizard.Model.Recipe;
import com.ece464.recipewizard.Service.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class DataQueryApi {

    @Autowired
    RecipeRepository repository;

    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }

    /**
     *
     * @param name
     * the names users are interested in searching for
     * @return
     * all matched recipes will be returned
     */

    @RequestMapping(path = "/search/recipe/{name}")
    public List<Recipe> getRecipeByNames(@PathVariable String name){
        return repository.getAllByNameContains(name);
    }

    /**
     *
     * @return
     * the list of all ingredients will be returned
     */
    @RequestMapping(path = "/info/list_name")
    public List<String> getNameList(){
        List<Recipe> result = repository.findAllByNameIsNotNull();
        List<String> names = new ArrayList<>();
        for(Recipe item : result){
            names.add(item.getName());
        }
        return names;
    }

    /**
     *
     * @param recipeName
     * name of the recipe
     * @return
     * all recipes whose names match with the input String
     * A list of recipes will be returned
     */

    @RequestMapping(path = "/info/{recipeName}")
    public List<Recipe> findRecipeByName(@PathVariable String recipeName){
        return repository.findAllByName(recipeName);
    }

    /**
     *
     * @param recipe
     * the name of the recipe users intend to find the ingredients for
     * @return
     * the list of ingredients of the first matched recipe with the inputted recipe name
     */
    @RequestMapping(path = "/info/list_ingredients/{recipe}")
    public JSONArray getIngredientsByName(@PathVariable String recipe){
        List<Recipe> result = repository.findAllByName(recipe);
        JSONArray ingredientList = new JSONArray();
        ingredientList.add(result.get(0).getIngredients());
        return ingredientList;
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
    @RequestMapping(path = "/insert/recipe")
    public boolean insertRecipe(JSONObject recipeInfo){

        return true;
    }
}
