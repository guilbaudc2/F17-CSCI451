package com.example.android.assignment10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;
import java.util.UUID;

public class RecipePagerActivity extends AppCompatActivity
{
    private static final String EXTRA_RECIPE_ID = "recipe_id";
    private ViewPager viewPager;
    private List<Recipe> recipes;

    public static Intent newIntent(Context packageContext, UUID recipeID)
    {
        Intent intent = new Intent(packageContext, RecipePagerActivity.class);
        intent.putExtra(EXTRA_RECIPE_ID, recipeID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_pager);
        viewPager = (ViewPager)findViewById(R.id.recipe_pager);
        recipes = RecipeSet.getList(this).getRecipes();
        UUID recipeID = (UUID)getIntent().getSerializableExtra(EXTRA_RECIPE_ID);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Recipe recipe = recipes.get(position);
                return RecipeDetailFragment.newInstance(recipe.getId());
            }

            @Override
            public int getCount() {
                return recipes.size();
            }
        });

        for(int i=0; i < recipes.size(); i++)
        {
            if(recipes.get(i).getId().equals(recipeID))
            {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }




}

