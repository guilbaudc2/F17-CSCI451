package com.example.android.assignment11;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Android on 11/12/2017.
 */

public class Recipe {
    private UUID id;
    private String smoothieName;
    private String ingredients;
    private String description;
    private String recipeSteps;
    private byte[] smoothieImage;
    private boolean favorite = false;

    public Recipe()
    {
        id = UUID.randomUUID();
    }

    public Recipe(UUID id)
    {
        this.id = id;
    }

    public UUID getId()
    {
        return id;
    }

    public String getSmoothieName() {
        return smoothieName;

    }

    public void setSmoothieName(String smoothieName) {
        this.smoothieName = smoothieName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }

    public byte[] getSmoothieImage() {
        return smoothieImage;
    }

    public void setSmoothieImage(byte[] smoothieImage) {
        this.smoothieImage = smoothieImage;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}
