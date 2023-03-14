package com.David.SpringRecipes.repositories;

import com.David.SpringRecipes.models.Recipe;

import java.util.HashMap;
import java.util.Map;

public class RecipesRepository { // this is a stand in for a H2 database which is being worked on on the SQL branch
    Recipe testRecipe1 = new Recipe("Pasta", "Peter", "this is Pasta", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", "Garfield's favourite dish", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});

    private Map<String, Recipe> db = new HashMap<>(){{
        put("Pasta", testRecipe1);
        put("Lasagna", testRecipe2);
    }};
}
