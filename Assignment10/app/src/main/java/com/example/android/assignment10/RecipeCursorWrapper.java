package com.example.android.assignment10;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;
import com.example.android.assignment10.RecipeDBSchema.RecipeTable;

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
//        byte[] smoothieImage = getBlob(getColumnIndex(RecipeTable.Cols.SMOOTHIE_IMAGE));

        Recipe recipe = new Recipe(UUID.fromString(uuidString));
        recipe.setSmoothieName(smoothieName);
        recipe.setDescription(description);
        recipe.setIngredients(ingredients);
//        recipe.setSmoothieImage(smoothieImage);

        return recipe;
    }
}
