package com.example.android.assignment10;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.UUID;

public class RecipeListActivity extends SingleFragmentActivity implements RecipeListFragment.Callbacks{

    @Override
    protected Fragment createFragment(){
            return new RecipeListFragment();
            }
    @Override
    public int getLayoutResId() {
        return R.layout.activity_master_layout;
    }

    public void onRecipeSelected(UUID recipeID) {
        //portrait
        if(findViewById(R.id.details_fragment_container) == null){
            Intent intent = RecipePagerActivity.newIntent(this, recipeID);
            startActivity(intent);
        }
        else {//landscape/tablet
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment oldFragment = manager.findFragmentById(R.id.details_fragment_container);
            Fragment newFragment = RecipeDetailFragment.newInstance(recipeID);

            if(oldFragment != null){
                transaction.remove(oldFragment);
            }

            transaction.add(R.id.details_fragment_container, newFragment);
            transaction.commit();

        }
    }

}