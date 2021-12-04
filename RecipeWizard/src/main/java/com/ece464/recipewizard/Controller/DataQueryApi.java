package com.ece464.recipewizard.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ece464.recipewizard.Model.Recipe;
import com.ece464.recipewizard.Service.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
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
     * one example would be beef
     * all names which contain beef will be returned
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
     * the list of all recipes' names will be returned
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
     * an example would be Grilled Country Style Ribs
     * this input has to be exactly same as the name in the database
     * otherwise, nothing will be returned
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
        return result.get(0).getIngredients();
    }



    /**
     *
     * @param ingredientName
     * the name of the ingredient
     * @return matched recipes
     * all recipe whose ingredients contain this ingredient name will be returned
     */
    @RequestMapping(path = "/search/ingredient/{ingredientName}")
    public List<Recipe> getRecipeByIngredients(@PathVariable String ingredientName){
        JSONArray ingredientNames = new JSONArray();
        ingredientNames.add(ingredientName);
        return repository.getAllByIngredientsContains(ingredientNames);
    }

    /**
     *
     * @return
     * all recommended recipe will be returned as Json array
     */
    @RequestMapping(path = "/search/recommend/{number}")
    public List<Recipe> recommendRecipe(@PathVariable int number){
        List<Recipe> result = repository.getAllByLabelIsNotNull();
        int min = 0;
        int max = result.size();
        List<Recipe> recipes = new LinkedList<>();
        for(int i = 0; i < number; i++){
            recipes.add(result.get((int)Math.floor(Math.random()*(max-min+1)+min)));
        }
        return recipes;
    }

    /**
     *
     * @param recipeInfo
     * the recipe users are interested in loading into the database
     * @return
     * status will be returned, to see the recipe has been updated or not
     */
    @PutMapping(path = "/insert")
    public boolean insertRecipe(@RequestHeader JSONObject recipeInfo){
        Recipe recipe = new Recipe();
        recipe.setIngredients(recipeInfo.getJSONArray("ingredients"));
        recipe.setImg_url(recipeInfo.getString("img_url"));
        recipe.setDescription(recipeInfo.getJSONArray("description"));
        recipe.setLabel(recipeInfo.getString("label"));
        recipe.setName(recipeInfo.getString("name"));
        repository.insert(recipe);
        return true;
    }
}
