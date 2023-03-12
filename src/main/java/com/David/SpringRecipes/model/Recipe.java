package com.David.SpringRecipes.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

// here we are modelling a recipe, this is the only object we will be passing to the website
public class Recipe {
    @NotEmpty
    private String name; // name will be unique and used as id instead of an integer id in order to make linking to recipes nicer
    @NotEmpty
    private String author;
    @NotEmpty
    private List<String> tags;
    @NotEmpty
    @PositiveOrZero
    private Integer prepTimeMinutes;
    @NotEmpty
    @PositiveOrZero
    private Integer cookTimeMinutes;
    @NotEmpty
    private List<String> ingredients;
    @NotEmpty
    private List<String> directions;
    // public Recipe(){    }
    public Recipe(String name, String author, List<String> tags, Integer prepTimeMinutes, Integer cookTimeMinutes,
                  List<String> ingredients, List<String> directions) {
        this.name = name; //TODO check if no recipe is called {name} already
        this.author = author;
        this.tags = tags;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //TODO check if no recipe is called {name} already
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public void setPrepTimeMinutes(Integer prepTimeMinutes) {
        this.prepTimeMinutes = prepTimeMinutes;
    }

    public Integer getCookTimeMinutes() {
        return cookTimeMinutes;
    }

    public void setCookTimeMinutes(Integer cookTimeMinutes) {
        this.cookTimeMinutes = cookTimeMinutes;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }
}
