package com.ece464.recipewizard.Service;

import com.alibaba.fastjson.JSONArray;
import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    public Recipe findByName(String name);
    public JSONArray findByIngredient(List<List<String>> ingredients);

}
