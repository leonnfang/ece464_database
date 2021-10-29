package com.ece464.recipewizard.Service;

import com.alibaba.fastjson.JSONArray;
import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByName(String name);
    JSONArray findByIngredient(List<List<String>> ingredients);
    // TODO should add more apis to fetch data
}
