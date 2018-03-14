package com.example.android.assignment11;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.sql.Blob;
import java.util.UUID;
import com.example.android.assignment11.RecipeDBSchema.RecipeTable;

/**
 * Created by Android on 11/12/2017.
 */

public class RecipeCursorWrapper extends CursorWrapper
{
    public RecipeCursorWrapper(Cursor cursor)
    {
        super(cursor);
    }

    public Recipe getRecipe()
    {
        String uuidString = getString(getColumnIndex(RecipeTable.Cols.UUID));
        String smoothieName = getString(getColumnIndex(RecipeTable.Cols.SMOOTHIE_NAME));
        String description = getString(getColumnIndex(RecipeTable.Cols.DESCRIPTION));
        String ingredients = getString(getColumnIndex(RecipeTable.Cols.INGREDIENTS));
        String recipeSteps = getString(getColumnIndex(RecipeTable.Cols.RECIPE_STEPS));
        byte[] smoothieImage = getBlob(getColumnIndex(RecipeTable.Cols.SMOOTHIE_IMAGE));
        int isFavorite = getInt(getColumnIndex(RecipeTable.Cols.FAVORITE));

        Recipe recipe = new Recipe(UUID.fromString(uuidString));
        recipe.setSmoothieName(smoothieName);
        recipe.setDescription(description);
        recipe.setIngredients(ingredients);
        recipe.setRecipeSteps(recipeSteps);
        recipe.setSmoothieImage(smoothieImage);
        recipe.setFavorite(isFavorite!=0);

        return recipe;
    }
}
