package com.ece464.recipewizard.Service;

import com.ece464.recipewizard.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findAllByName(String name);
    List<Recipe> findAllByNameIsNotNull();
    List<Recipe> getAllByNameContains(String name);
    List<Recipe> getAllByLabelIsNotNull();
    List<Recipe> getAllByIngredientsListContains(String name);
}
