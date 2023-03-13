package com.David.SpringRecipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

// here we are modelling a recipe, this is the only object we will be passing to the website
public class Recipe {
    @NotEmpty
    private String name; // name will be unique and used as id instead of an integer id in order to make linking to recipes nicer
    @NotEmpty
    private String author;
    @JsonIgnore // doesn't show the list in the pop-up after submitting the form
    private String[] tags;
    @PositiveOrZero
    private Integer prepTimeMinutes;
    @PositiveOrZero
    private Integer cookTimeMinutes;
    @JsonIgnore // doesn't show the list in the pop-up after submitting the form
    private String[] ingredients;
    @JsonIgnore // doesn't show the list in the pop-up after submitting the form
    private String[] directions;
    // for testing purposes
    public Recipe(){ //empty constructor

    }
    public Recipe(String name, String author, Integer prepTimeMinutes, Integer cookTimeMinutes) {
        this.name = name; //TODO check if no recipe is called {name} already
        this.author = author;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
    }
    public Recipe(String name, String author, String[] tags, Integer prepTimeMinutes, Integer cookTimeMinutes,
                  String[] ingredients, String[] directions) {
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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
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

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }
}
