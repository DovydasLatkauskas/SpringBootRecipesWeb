package com.David.SpringRecipes.controllers;

import com.David.SpringRecipes.models.Recipe;
import com.David.SpringRecipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Controller
public class WebThymeleafController {
    private final RecipeService recipeService;

    public WebThymeleafController(@Autowired RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{name}")
    public String getByName(@PathVariable String name, Model model) {
        Recipe recipe = recipeService.get(name);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("recipe", recipe);
        return "recipe";
    }
    @GetMapping("/")
    public String allRecipes(Model model) {
        Collection<Recipe> recipes = recipeService.getAll();
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }
    @GetMapping("/upload")
    public String uploadRecipe(Model model){
        return "upload";
    }
    @GetMapping("/{name}/delete")
    public String deleteRecipe(@PathVariable("name")String name){
        Recipe recipe = recipeService.remove(name);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/";
    }
}