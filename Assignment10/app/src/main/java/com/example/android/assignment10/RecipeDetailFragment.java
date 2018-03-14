package com.example.android.assignment10;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;


/**
 * A placeholder fragment containing a simple view.
 */
public class RecipeDetailFragment extends Fragment {
    View view;
    private Recipe recipe;
    private Callbacks callbacks;

    private static final String ARGS_RECIPE_ID = "recipe_id";


    public interface Callbacks {
        void onRecipeUpdated(int recipeID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID recipeID = (UUID)getArguments().getSerializable(ARGS_RECIPE_ID);
        recipe = (RecipeSet.getList(getActivity())).getRecipe(recipeID);
    }

    public static RecipeDetailFragment newInstance(UUID recipeID)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_RECIPE_ID, recipeID);
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState)
    {
        view =  inflater.inflate(R.layout.fragment_recipe_detail, parent, false);
        initSmoothieNameET(view);
        initDescriptionET(view);
        initIngredientsET(view);
        initSubmitBtn();
        return view;
    }

    public void initSmoothieNameET(View view)
    {
        EditText smoothieNameET = (EditText) view.findViewById(R.id.et_recipe_smoothieName);
        smoothieNameET.setText(recipe.getSmoothieName());
        smoothieNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setSmoothieName(editable.toString());
            }
        });
    }

    public void initDescriptionET(View view)
    {
        EditText descriptionET = (EditText) view.findViewById(R.id.et_recipe_description);
        descriptionET.setText(recipe.getDescription());
        descriptionET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setDescription(editable.toString());
            }
        });
    }

    public void initIngredientsET(View view)
    {
        EditText ingredientsET = (EditText) view.findViewById(R.id.et_recipe_ingredients);
        ingredientsET.setText(recipe.getSmoothieName());
        ingredientsET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(
                    CharSequence text, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                recipe.setIngredients(editable.toString());
            }
        });
    }

    public void initSubmitBtn(){
        Button submitBtn = (Button)view.findViewById(R.id.button_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RecipeListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != Activity.RESULT_OK)return;
    }

    @Override
    public void onPause() {
        super.onPause();

        RecipeSet.getList(getActivity()).updateRecipe(recipe);
    }
}
