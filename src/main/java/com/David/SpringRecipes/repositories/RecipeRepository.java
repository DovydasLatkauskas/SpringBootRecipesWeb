package com.David.SpringRecipes.repositories;

import com.David.SpringRecipes.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

}