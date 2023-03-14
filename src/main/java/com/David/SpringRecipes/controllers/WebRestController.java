package com.David.SpringRecipes.controllers;

import com.David.SpringRecipes.models.Recipe;
import com.David.SpringRecipes.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class WebRestController {
    private final RecipeService recipeService;

    public WebRestController(@Autowired RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all-recipes")
    public Iterable<Recipe> get() {
        return recipeService.getAll();
    }

//    @DeleteMapping("/delete/{name}")
//    public void delete(@PathVariable String name){
//        Recipe recipe = db.remove(name);
//        if(recipe == null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
    @PostMapping(value = "/upload")
    public Recipe create(@RequestBody @Valid Recipe recipe){
        recipeService.create(recipe);
        return recipe;
    }
}
