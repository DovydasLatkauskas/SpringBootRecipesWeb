package com.David.SpringRecipes.web;

import com.David.SpringRecipes.model.Recipe;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

//@RestController
@Controller
public class SpringRecipesController {
    // for testing purposes only
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    private ArrayList<Recipe> db = new ArrayList<Recipe>(){{
        add(testRecipe1);
        add(testRecipe2);
    }};


    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }
    @GetMapping("/all-recipes")
    public Collection<Recipe> get() {
        return db;
    }
//    @GetMapping("/recipes/{name}")
//    public Recipe getByName(@PathVariable String name) {
//        Recipe recipe = db.get(name);
//        if(recipe == null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return recipe;
//    }

    @GetMapping("/recipes")
    public String recipes(Model model) {
        ArrayList<Recipe> recipes = db;
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

//    @DeleteMapping("/recipes/{name}")
//    public void delete(@PathVariable String name){
//        Recipe recipe = db.remove(name);
//        if(recipe == null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
    @PostMapping(value = "/recipes/submit")
    public Recipe create(@RequestBody @Valid Recipe recipe){
        db.add(recipe);
        return recipe;
    }
}
