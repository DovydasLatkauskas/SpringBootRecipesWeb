package com.David.SpringRecipes.services;

import com.David.SpringRecipes.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {
    // for testing purposes only
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", "this is Pasta", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", "Garfield's favourite dish", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    private Map<String, Recipe> db = new HashMap<>(){{
        put("Pasta", testRecipe1);
        put("Lasagna", testRecipe2);
    }};

    public Recipe get(String name) {
        return db.get(name);
    }
    public Collection<Recipe> getAll() {
        return db.values();
    }
    public Recipe remove(String name) {
        return db.remove(name);
    }

    public void create(Recipe recipe) {
        db.put(recipe.getName(), recipe);
    }
}
