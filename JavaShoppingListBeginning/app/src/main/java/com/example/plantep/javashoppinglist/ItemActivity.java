package com.example.plantep.javashoppinglist;

import android.support.v4.app.Fragment;

import java.util.UUID;

public class ItemActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        UUID todoId = (UUID) getIntent().getSerializableExtra(
                ShoppingListFragment.EXTRA_TODO_ID);
        return ItemFragment.newInstance(todoId);
    }
}
