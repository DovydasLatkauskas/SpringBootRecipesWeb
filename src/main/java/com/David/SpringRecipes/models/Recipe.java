package com.David.SpringRecipes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

// here we are modelling a recipe, this is the only object we will be passing to the website
public class Recipe {
    @NotEmpty //validation that we arent creating an empty recipe
    private String name; // name will be unique and used as id instead of an integer id in order to make linking to recipes nicer
    @NotEmpty
    private String author;
    @NotEmpty
    private String description;
    private String[] tags;
    @PositiveOrZero //validation for creating the recipe
    private Integer prepTimeMinutes;
    @PositiveOrZero
    private Integer cookTimeMinutes;
    private String[] ingredients;
    private String[] directions;
    
    //Constructors
    public Recipe(){

    }
    public Recipe(String name, String author, Integer prepTimeMinutes, Integer cookTimeMinutes) {
        this.name = name;
        this.author = author;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
    }
    public Recipe(String name, String author, String description, String[] tags, Integer prepTimeMinutes, Integer cookTimeMinutes,
                  String[] ingredients, String[] directions) { //the full constructor
        this.name = name;
        this.author = author;
        this.description = description;
        this.tags = tags;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
