package com.example.plantep.javashoppinglist;

import android.support.v4.app.Fragment;

public class ShoppingListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ShoppingListFragment();
    }

 }
