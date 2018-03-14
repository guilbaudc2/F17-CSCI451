package com.example.android.assignment11;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.UUID;

public class RecipeListActivity extends SingleFragmentActivity implements RecipeDetailFragment.Callbacks{

    @Override
    protected Fragment createFragment(){
        return new RecipeListFragment();
    }
    @Override
    public int getLayoutResId() {
        return R.layout.activity_master_layout;
    }

    @Override
    public void onRecipeUpdated(int recipeID) {
        FragmentManager manager = getSupportFragmentManager();
        RecipeListFragment listFragment = (RecipeListFragment)
                manager.findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}