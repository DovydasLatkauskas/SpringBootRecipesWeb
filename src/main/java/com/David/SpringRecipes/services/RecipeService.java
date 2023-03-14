package com.David.SpringRecipes.services;

import com.David.SpringRecipes.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {
    // for testing purposes only
    // will be removed once h2 database functionality is added
    Recipe testRecipe1 = new Recipe("Kombucha", "Peter", "The simple yet comprehensive guide to making tasty kombucha. This is intended to give you an initial overview of the process. I strongly encourage you to experiment with brewing times, teas, flavors, etc. The scoby is extremely tolerant, so the worst that can happen is that your resulting kombucha won’t be that great.",
            new String[]{"Drink", "Sweet"}, 10, 0, new String[]{"5l (1 gallon) jar", "3-5 tbsp black (or green) tea", "2 cups sugar", "kombucha scoby", "optional additional teas", "optional juices, fruits, spices", "patience ;)"}, new String[]{"Boil 1-2l of water.", "Rinse all the dishes you will be working with boiling water; this is important so the brew doesn’t go bad while fermenting.", "Steep 3-5 tbsp (or 5-6 bags) of tee in 3-5 cups of water.", "Strain the leaves from the tea and add 2 cups of sugar (or honey).", "Add other optional teas to your liking; I like to add a good handful of rosella tea; steep and strain this in boiling water separately.", "Add 4l of water to the tea concentrate and pour into a wide mouthed jar.", "Let the tea sit until it is less than 40°C; add ice cubes if it has to go quick.",
            "Add your scoby to the jar and seal the mouth tightly with a cloth or paper towel and a rubber band. ", "Let the jar sit in a warm dark spot for 10-14 days."});
    Recipe testRecipe2 = new Recipe("Lasagna", "Garfield", "Garfield's favourite dish", new String[]{"Buenos Aires", "Córdoba", "La Plata"}, 5, 10,
            new String[]{"Buenos Aires", "Córdoba", "La Plata"}, new String[]{"Buenos Aires", "Córdoba", "La Plata"});
    private Map<String, Recipe> db = new HashMap<>(){{
        put(testRecipe1.getName(), testRecipe1);
        put(testRecipe2.getName(), testRecipe2);
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
