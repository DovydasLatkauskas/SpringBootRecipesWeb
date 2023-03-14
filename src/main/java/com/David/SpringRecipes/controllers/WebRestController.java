package com.David.SpringRecipes.controllers;

import com.David.SpringRecipes.model.Recipe;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebRestController {
    // for testing only
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", "this is Pasta", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", "Garfield's favourite dish", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    private Map<String, Recipe> db = new HashMap<>(){{
        put("Pasta", testRecipe1);
        put("Lasagna", testRecipe2);
    }};

    @GetMapping("/all-recipes")
    public Collection<Recipe> get() {
        return db.values();
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
        db.put(recipe.getName(), recipe);
        return recipe;
    }
}
