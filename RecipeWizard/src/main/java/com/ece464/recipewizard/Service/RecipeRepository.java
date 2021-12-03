package com.ece464.recipewizard.Service;

import com.alibaba.fastjson.JSONArray;
import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findAllByName(String name);
    // todo update ingredients
    List<Recipe> findByIngredient(List<List<String>> ingredients);
    List<Recipe> findAllByNameIsNotNull();
    List<Recipe> getAllByNameContains(String name);
}
