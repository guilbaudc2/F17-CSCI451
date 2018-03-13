package com.example.android.smoothierecipeapplication;

/**
 * Created by Android on 10/7/2017.
 */

public class Recipe {
    private String smoothieName;
    private int photoID;
    private String[] ingredients;
    private String[] reviews;
    private String description;

    public Recipe(String smoothieName, int photoID, String[] ingredients, String description, String[] reviews) {
        this.smoothieName = smoothieName;
        this.photoID = photoID;
        this.ingredients = ingredients;
        this.description = description;
        this.reviews = reviews;
    }

    public String getSmoothieName() {
        return smoothieName;

    }

    public void setSmoothieName(String smoothieName) {
        this.smoothieName = smoothieName;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getReviews() {
        return reviews;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
}
