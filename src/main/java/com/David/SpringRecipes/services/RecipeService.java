package com.David.SpringRecipes.services;

import com.David.SpringRecipes.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    // for testing purposes only
    // will be removed once h2 database functionality is added
    Recipe kombucha = new Recipe("Kombucha", "Peter", "The simple yet comprehensive guide to making tasty kombucha. This is intended to give you an initial overview of the process. I strongly encourage you to experiment with brewing times, teas, flavors, etc. The scoby is extremely tolerant, so the worst that can happen is that your resulting kombucha won’t be that great.",
            new String[]{"Drink", "Sweet"}, 10, 0, new String[]{"5l (1 gallon) jar", "3-5 tbsp black (or green) tea", "2 cups sugar", "kombucha scoby", "optional additional teas", "optional juices, fruits, spices", "patience ;)"}, new String[]{"Boil 1-2l of water.", "Rinse all the dishes you will be working with boiling water; this is important so the brew doesn’t go bad while fermenting.", "Steep 3-5 tbsp (or 5-6 bags) of tee in 3-5 cups of water.", "Strain the leaves from the tea and add 2 cups of sugar (or honey).", "Add other optional teas to your liking; I like to add a good handful of rosella tea; steep and strain this in boiling water separately.", "Add 4l of water to the tea concentrate and pour into a wide mouthed jar.", "Let the tea sit until it is less than 40°C; add ice cubes if it has to go quick.",
            "Add your scoby to the jar and seal the mouth tightly with a cloth or paper towel and a rubber band. ", "Let the jar sit in a warm dark spot for 10-14 days."});
    Recipe pancakes = new Recipe("Classic Pancakes", "John Smith", "A classic pancake recipe that everyone loves", new String[]{"pancakes", "breakfast", "easy"}, 10, 15,
            new String[]{"1 cup all-purpose flour", "2 tbsp sugar", "2 tsp baking powder", "1/2 tsp salt", "1 egg", "1 cup milk", "2 tbsp butter, melted"}, new String[]{"In a mixing bowl, whisk together the flour, sugar, baking powder, and salt.", "In another bowl, whisk together the egg, milk, and melted butter.", "Add the wet ingredients to the dry ingredients and whisk until just combined.", "Heat a nonstick skillet over medium heat.", "Pour 1/4 cup of batter onto the skillet and cook until bubbles form on the surface, then flip and cook until golden brown."});

    Recipe chickenParmesan = new Recipe("Chicken Parmesan", "John Doe", "A classic Italian-American dish of breaded chicken cutlets baked with tomato sauce and mozzarella cheese", new String[]{"chicken", "Italian", "dinner", "entree"}, 20, 30,
            new String[]{"4 boneless, skinless chicken breasts", "1/2 cup all-purpose flour", "2 eggs, beaten", "1 cup Italian-seasoned breadcrumbs", "2 cups marinara sauce", "1 cup shredded mozzarella cheese", "1/4 cup grated Parmesan cheese", "1/4 cup chopped fresh parsley leaves"}, new String[]{"Preheat the oven to 375°F. Lightly grease a baking sheet.", "Dredge each chicken breast in the flour, shaking off excess. Dip into the eggs, then coat in breadcrumbs, pressing to adhere.", "Place the chicken onto the prepared baking sheet and bake for 25 minutes. Remove from the oven and spoon marinara sauce over each chicken breast. Top with mozzarella and Parmesan cheeses.", "Return to the oven and bake until the cheese is melted and bubbly, about 5 more minutes. Garnish with parsley and serve."});

    Recipe spaghettiCarbonara = new Recipe("Spaghetti Carbonara", "Emily Johnson", "A traditional Italian pasta dish with a rich and creamy sauce", new String[]{"pasta", "Italian", "creamy"}, 15, 20,
            new String[]{"1 lb spaghetti", "4 oz pancetta, diced", "4 cloves garlic, minced", "4 egg yolks", "1 cup grated Parmesan cheese", "Salt and pepper to taste"}, new String[]{"Cook the spaghetti according to package instructions.", "While the spaghetti is cooking, cook the pancetta in a large skillet over medium heat until crispy.", "Add the garlic and cook for another minute.", "In a mixing bowl, whisk together the egg yolks, Parmesan cheese, salt, and pepper.", "Drain the spaghetti and add it to the skillet with the pancetta and garlic. Turn off the heat and add the egg mixture to the skillet, tossing the pasta until it is coated in the sauce."});

    Recipe chocolateChipCookies = new Recipe("Chocolate Chip Cookies", "Jane Smith", "A classic cookie with gooey melted chocolate chips in every bite", new String[]{"cookies", "chocolate", "dessert", "baking"}, 15, 10,
            new String[]{"2 1/4 cups all-purpose flour", "1 tsp baking soda", "1 tsp salt", "1 cup unsalted butter, softened", "3/4 cup white sugar", "3/4 cup brown sugar", "2 large eggs", "2 tsp vanilla extract", "2 cups semisweet chocolate chips"}, new String[]{"Preheat the oven to 375°F. Line a baking sheet with parchment paper.", "In a medium bowl, whisk together the flour, baking soda, and salt. Set aside.", "In a large bowl, cream together the butter, white sugar, and brown sugar until light and fluffy. Beat in the eggs, one at a time, then stir in the vanilla.", "Gradually mix in the dry ingredients until just combined. Stir in the chocolate chips.", "Drop rounded tablespoonfuls of the dough onto the prepared baking sheet. Bake for 10-12 minutes or until golden brown."});
    private Map<String, Recipe> db = new HashMap<>(){{
        put(kombucha.getName(), kombucha);
        put(pancakes.getName(), pancakes);
        put(spaghettiCarbonara.getName(), spaghettiCarbonara);
        put(chickenParmesan.getName(), chickenParmesan);
        put(chocolateChipCookies.getName(), chocolateChipCookies);
    }};
    // sorry for the mess :D



    public Recipe get(String name) {
        return db.get(name); // function for getting a recipe by name
    }

    public Collection<Recipe> getAll() {
        return db.values(); //function for getting all recipes in the database as its currently represented
    }

    public List<Recipe> getRecipesByTag(String tag) {
        Collection<Recipe> recipes = db.values();
        List<Recipe> matchedRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (Arrays.asList(recipe.getTags()).contains(tag)) {
                matchedRecipes.add(recipe);
            }
        }

        return matchedRecipes;
    }

    public Recipe remove(String name) {
        return db.remove(name); //function for removing a recipe by name
    }

    public void create(Recipe recipe) {
        db.put(recipe.getName(), recipe); //function for adding a recipe to the database
    }
}
