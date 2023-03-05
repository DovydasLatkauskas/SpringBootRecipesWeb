package com.David.SpringRecipes.model;

import java.util.List;

public class Recipe {
    private Integer id;
    private String name;
    private String author;
    private List<String> tags;
    private int prepTime;
    private int cookTime;
    private List<String> ingredients;
    private List<String> directions;
    // public Recipe(){    }
    public Recipe(String name, String author, List<String> tags, int prepTime, int cookTime,
                  List<String> ingredients, List<String> directions) {
        this.name = name;
        this.author = author;
        this.tags = tags;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Recipe get(){

    }

}
