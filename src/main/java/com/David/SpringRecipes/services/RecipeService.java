package com.David.SpringRecipes.services;

import com.David.SpringRecipes.models.Recipe;
import com.David.SpringRecipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe get(String name) {
        return recipeRepository.findById(name).orElse(null);
    }
    public Iterable<Recipe> getAll() {
        return recipeRepository.findAll();
    }
    public void remove(String name) {
        recipeRepository.deleteById(name);
    }

    public void create(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
