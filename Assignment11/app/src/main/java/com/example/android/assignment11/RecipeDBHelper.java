package com.example.android.assignment11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.assignment11.RecipeDBSchema.RecipeTable;

/**
 * Created by Android on 11/12/2017.
 */

public class RecipeDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipe.db";
    private static final int VERSION = 1;

    public RecipeDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " +  RecipeTable.NAME + "(" +
                "id integer primary key autoincrement, " +
                RecipeTable.Cols.UUID + ", " +
                RecipeTable.Cols.SMOOTHIE_NAME + ", " +
                RecipeTable.Cols.DESCRIPTION + ", " +
                RecipeTable.Cols.INGREDIENTS + ", " +
                RecipeTable.Cols.RECIPE_STEPS + ", " +
                RecipeTable.Cols.SMOOTHIE_IMAGE + "," +
                RecipeTable.Cols.FAVORITE + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
