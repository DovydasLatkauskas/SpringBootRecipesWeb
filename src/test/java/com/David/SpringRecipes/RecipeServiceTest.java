package com.David.SpringRecipes;

import com.David.SpringRecipes.models.Recipe;
import com.David.SpringRecipes.services.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class RecipeServiceTest {

    private RecipeService recipeService;

    @BeforeEach
    public void setUp() {
        recipeService = new RecipeService();
    }

    @Test
    public void testGetAllRecipes() {
        Collection<Recipe> recipes = recipeService.getAll();
        Assertions.assertEquals(5, recipes.size());
    }

    @Test
    public void testGetRecipeByName() {
        Recipe recipe = recipeService.get("Kombucha");
        Assertions.assertEquals("Kombucha", recipe.getName());
    }

    @Test
    public void testGetRecipesByTag() {
        List<Recipe> recipes = recipeService.getRecipesByTag("Drink");
        Assertions.assertEquals(1, recipes.size());
    }

    @Test
    public void testAddRecipe() {
        Recipe newRecipe = new Recipe("Test Recipe", "Test Author", "Test Description", new String[]{"Test Category"}, 10, 10,
                new String[]{"Ingredient 1", "Ingredient 2"}, new String[]{"Step 1", "Step 2"});
        recipeService.create(newRecipe);
        Collection<Recipe> recipes = recipeService.getAll();
        Assertions.assertEquals(6, recipes.size());
    }

    @Test
    public void testRemove(){
        Collection<Recipe> recipes = recipeService.getAll();
        recipeService.remove("pancakes");
        Assertions.assertEquals(5, recipes.size());
    }

}
