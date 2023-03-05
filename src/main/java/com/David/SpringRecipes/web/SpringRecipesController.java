package com.David.SpringRecipes.web;

import com.David.SpringRecipes.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpringRecipesController {
    private List<Recipe> db;

    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/{name}")
    public Recipe get(){ return recipeService.get()}
}
