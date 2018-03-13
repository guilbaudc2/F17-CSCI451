package com.example.plantep.javashoppinglist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class ItemFragment extends Fragment {
    private static final String ARGS_TODO_ID = "item_id";
    private Item item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID todoId = (UUID) getArguments().getSerializable(ARGS_TODO_ID);
        item = (ShoppingList.getList()).getItem(todoId);
    }

    public ItemFragment() {
    }

    public static ItemFragment newInstance(UUID todoId) {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_TODO_ID, todoId);
        ItemFragment toDoFragment = new ItemFragment();
        toDoFragment.setArguments(args);
        return toDoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        initCountET(view);
        initTitleET(view);
        initCategoryET(view);
        initCompleteCheck(view);
        return view;
    }

    private void initCountET(View view) {
        EditText countET = (EditText) view.findViewById(R.id.et_item_count);
        countET.setText("" + item.getCount());
        countET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().trim().equals("")){
                    item.setCount(0);
                }
                else if(android.text.TextUtils.isDigitsOnly(editable.toString().trim())){
                    item.setCount(Integer.parseInt(editable.toString()));
                }
            }
        });
    }

    private void initTitleET(View view) {
        EditText titleET = (EditText) view.findViewById(R.id.et_item_title);
        titleET.setText(item.getTitle());
        titleET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                item.setTitle(editable.toString());
            }
        });
    }

    private void initCategoryET(View view) {
        EditText categoryET = (EditText) view.findViewById(R.id.et_item_category);
        categoryET.setText(item.getCategory());
        categoryET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                item.setCategory(editable.toString());
            }
        });
    }

    private void initCompleteCheck(View view){
        CheckBox completeCheck = (CheckBox) view.findViewById(R.id.edit_item_incart);
        completeCheck.setChecked(item.isComplete());
        completeCheck.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {
                        item.setComplete(isChecked);
                    }
                }
        );
    }

}













