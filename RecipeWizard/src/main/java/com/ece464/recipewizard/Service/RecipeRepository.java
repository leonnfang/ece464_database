package com.ece464.recipewizard.Service;

import com.alibaba.fastjson.JSONArray;
import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findAllByName(String name);
    List<Recipe> findAllByNameIsNotNull();
    List<Recipe> getAllByNameContains(String name);
    List<Recipe> getAllByIngredientsContains(JSONArray ingredients);
    List<Recipe> getAllByLabelIsNotNull();
}
