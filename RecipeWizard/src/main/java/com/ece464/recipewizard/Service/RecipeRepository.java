package com.ece464.recipewizard.Service;

import com.alibaba.fastjson.JSONArray;
import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    public List<Recipe> findByName(String name);
    @Query("{'name' : {$ne : null}}")
    public JSONArray getIngredientsList();

    public JSONArray getAllByNameRegex(String regex);

    public JSONArray findByIngredient(List<List<String>> ingredients);

    @Query("{'name' : {$regex : ?0 }}")
    public JSONArray getRecipeByNameRegex(String name);

    public List<Recipe> findAllByNameIsNotNull();
    public List<Recipe> findAllByNameContains(String name);
}
