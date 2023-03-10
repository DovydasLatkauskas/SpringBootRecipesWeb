package com.David.SpringRecipes.web;

import com.David.SpringRecipes.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class SpringRecipesController {
    // for testing purposes only
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")), 5, 10,
            new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")), new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")));
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")), 5, 10,
            new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")), new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")));
    private Map<String, Recipe> db = new HashMap<>(){{
        put("Pasta", testRecipe1);
        put("Lasagna", testRecipe2);
    }};


    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }
    @GetMapping("/recipes")
    public Collection<Recipe> get() {
        return db.values();
    }
    @GetMapping("/recipes/{name}")
    public Recipe getByName(@PathVariable String name) {
        Recipe recipe = db.get(name);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }
    @DeleteMapping("/recipes/{name}")
    public void delete(@PathVariable String name){
        Recipe recipe = db.remove(name);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/recipes/")
    public Recipe create(@RequestBody Recipe recipe){
        db.put(recipe.getName(), recipe);
        return recipe;
    }

    //@GetMapping("/{name}")
    //public Recipe get(){ return recipeService.get();}
}
