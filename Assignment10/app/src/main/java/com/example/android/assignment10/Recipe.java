package com.example.android.assignment10;

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
//    private byte smoothieImage;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


//    public byte getSmoothieImage() {
//        return smoothieImage;
//    }
//
//    public void setSmoothieImage(byte[] smoothieImage) {
//        this.smoothieImage = smoothieImage;
//    }

}
