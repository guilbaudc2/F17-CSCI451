package com.example.android.smoothierecipeapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeDetailActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        int recipeID = (int)getIntent().getIntExtra(RecipeListFragment.RECIPE_ID, 0);
        return RecipeDetailFragment.newInstance(recipeID);
    }
}