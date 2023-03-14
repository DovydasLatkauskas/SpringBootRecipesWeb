package com.David.SpringRecipes.controllers;

import com.David.SpringRecipes.model.Recipe;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Controller
public class WebThymeleafController {
    // for testing purposes only
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", "this is Pasta", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", "Garfield's favourite dish", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    private Map<String, Recipe> db = new HashMap<>(){{
        put("Pasta", testRecipe1);
        put("Lasagna", testRecipe2);
    }};

    @GetMapping("/{name}")
    public String getByName(@PathVariable String name, Model model) {
        Recipe recipe = db.get(name);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    @GetMapping("/")
    public String recipes(Model model) {
        Collection<Recipe> recipes = db.values();
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }
}