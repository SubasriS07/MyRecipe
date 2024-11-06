package com.example.myrecipe;

import java.io.Serializable;


public class Recipe implements Serializable {
    private String name;
    private String ingredients;
    private String steps;
    private int imageResource; // For storing image as a resource ID

    // Constructor
    public Recipe(String name, String ingredients, String steps, int imageResource) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imageResource = imageResource; // Image resource ID
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }


    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
