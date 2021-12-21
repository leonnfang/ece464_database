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
@CrossOrigin(origins= "*")
public class DataQueryApi {

    @Autowired
    RecipeRepository repository;

    @CrossOrigin
    @RequestMapping(path = "/health")
    public boolean health(){
        return true;
    }

    /**
     *
     * @param name
     * the names users are interested in searching for
     * one example would be apple
     * all names containing apple will be returned
     * @return
     * all matched recipes will be returned
     */

    @CrossOrigin(origins= "*")
    @RequestMapping(path = "/search/recipe_contains/{name}")
    public List<Recipe> getRecipeByNames(@PathVariable String name){
        return repository.findByNameRegex(name);
//        return repository.getAllByNameContains(name);
    }

    /**
     *
     * @return
     * the list of all recipes' names will be returned
     */
    @CrossOrigin
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

    @CrossOrigin
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
    @RequestMapping(path = "/search/list_ingredients/{recipe}")
    public JSONArray getIngredientsByName(@PathVariable String recipe){
        List<Recipe> result = repository.findAllByName(recipe);
        return result.get(0).getIngredients();
    }



    /**
     *
     * @param ingredientName
     * the name of the ingredient
     * @return matched recipes
     * all recipe whose ingredients contain the input will be returned
     */
    @CrossOrigin
    @RequestMapping(path = "/search/ingredient_name_contains/{ingredientName}")
    public List<Recipe> getRecipeByIngredients(@PathVariable String ingredientName){
        return repository.findByIngredientsListRegex(ingredientName);
//        return repository.getAllByIngredientsListContains(ingredientName);
    }

    /**
     *
     * @return
     * all recommended recipe will be returned as Json array
     */
    @CrossOrigin
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
    @CrossOrigin
    @PutMapping(path = "/insert")
    public boolean insertRecipe(@RequestHeader JSONObject recipeInfo){
        Recipe recipe = new Recipe();
        recipe.setIngredients(recipeInfo.getJSONArray("ingredients"));
        recipe.setImg_url(recipeInfo.getString("img_url"));
        recipe.setDescription(recipeInfo.getJSONArray("description"));
        recipe.setLabel(recipeInfo.getString("label"));
        recipe.setName(recipeInfo.getString("name"));
        recipe.setIngredientsList(recipeInfo.getString("ingredients_list"));
        repository.insert(recipe);
        return true;
    }
}
