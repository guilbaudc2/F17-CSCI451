package com.example.android.assignment11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static android.R.attr.id;

/**
 * Created by Android on 11/12/2017.
 */

public class RecipeSet {
    private static RecipeSet recipeSet;

    private final SQLiteDatabase database;

    private RecipeSet(Context context)
    {
        database = new RecipeDBHelper(context).getWritableDatabase();
    }

    public static RecipeSet getList(Context context)
    {
        if(recipeSet == null)
        {
            recipeSet = new RecipeSet(context);
        }

        return recipeSet;
    }

    public void addRecipe(Recipe recipe)
    {
        ContentValues values = getContentValues(recipe);
        database.insert(RecipeDBSchema.RecipeTable.NAME, null, values);
    }



    public List<Recipe> getRecipes()
    {
        List<Recipe> recipes = new ArrayList<>();
        RecipeCursorWrapper cursor = queryRecipes(null, null);

        try {
            cursor.moveToFirst();

            while(!cursor.isAfterLast())
            {
                recipes.add(cursor.getRecipe());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return recipes;
    }

    public List<Recipe> getFavorites()
    {
        List<Recipe> recipes = new ArrayList<>();
        RecipeCursorWrapper cursor = queryFavorites(null, null);

        try {
            cursor.moveToFirst();

            while(!cursor.isAfterLast())
            {
                if(cursor.getRecipe().isFavorite()) {
                    recipes.add(cursor.getRecipe());
                }
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return recipes;
    }



    public Recipe getRecipe(UUID id)
    {
        RecipeCursorWrapper cursor = queryRecipes(
                RecipeDBSchema.RecipeTable.Cols.UUID + "=?",
                new String[]{id.toString()}
        );

        try
        {
            if(cursor.getCount() == 0) return null;
            cursor.moveToFirst();
            return cursor.getRecipe();
        } finally {
            cursor.close();
        }
    }

    public void updateRecipe(Recipe recipe)
    {
        String uuidString = recipe.getId().toString();
        ContentValues values = getContentValues(recipe);
        database.update(RecipeDBSchema.RecipeTable.NAME, values,
                RecipeDBSchema.RecipeTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    public void deleteRecipe(Recipe recipe)
    {
        String uuidString = recipe.getId().toString();
        database.delete(RecipeDBSchema.RecipeTable.NAME, RecipeDBSchema.RecipeTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    public static ContentValues getContentValues(Recipe recipe)
    {
        ContentValues values = new ContentValues();

        values.put(RecipeDBSchema.RecipeTable.Cols.UUID, recipe.getId().toString());
        values.put(RecipeDBSchema.RecipeTable.Cols.SMOOTHIE_NAME, recipe.getSmoothieName());
        values.put(RecipeDBSchema.RecipeTable.Cols.DESCRIPTION, recipe.getDescription());
        values.put(RecipeDBSchema.RecipeTable.Cols.INGREDIENTS, recipe.getIngredients());
        values.put(RecipeDBSchema.RecipeTable.Cols.RECIPE_STEPS, recipe.getRecipeSteps());
        values.put(RecipeDBSchema.RecipeTable.Cols.SMOOTHIE_IMAGE, recipe.getSmoothieImage());
        values.put(RecipeDBSchema.RecipeTable.Cols.FAVORITE, recipe.isFavorite() ? 1 : 0);
        return values;
    }

    private RecipeCursorWrapper queryRecipes(String whereClause, String[] whereArgs)
    {
        Cursor cursor = database.query(
                RecipeDBSchema.RecipeTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new RecipeCursorWrapper(cursor);
    }

    private RecipeCursorWrapper queryFavorites (String whereClause, String [] whereArgs)
    {
        Cursor cursor = database.query(
                RecipeDBSchema.RecipeTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new RecipeCursorWrapper(cursor);
    }

}

