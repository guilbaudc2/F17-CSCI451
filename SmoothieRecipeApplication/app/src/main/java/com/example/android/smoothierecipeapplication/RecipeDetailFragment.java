package com.example.android.smoothierecipeapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeDetailFragment extends Fragment {
    View view;
    Recipe recipe;

    RatingBar latestRating;
    EditText latestReview;
    TextView recipeReviews;

    String starValues = "";
    int numEmptyStars;

    String[] recipeReviewsList;
    String currentReviewString;

    private static final String RECIPE_ID = "recipe_id";

    public RecipeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int recipeID = (int)getArguments().getInt(RECIPE_ID);
        recipe = RecipeSet.getRecipeSet().getRecipe(recipeID);
    }

    public static RecipeDetailFragment newInstance(int recipeID){
        Bundle args = new Bundle();
        args.putInt(RECIPE_ID, recipeID);
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        latestRating = (RatingBar)view.findViewById(R.id.recipe_rating);
        latestReview = (EditText)view.findViewById(R.id.recipe_rating_text);
        initRecipeDetails();
        initNewReview();

        return view;
    }

    public void initRecipeDetails(){
        String[] recipeIngredientsList = new String[0];
        TextView recipeName = (TextView)view.findViewById(R.id.recipe_name);
        TextView recipeDescription = (TextView)view.findViewById(R.id.recipe_description);
        TextView recipeIngredients = (TextView)view.findViewById(R.id.recipe_ingredients);
        recipeReviews  = (TextView)view.findViewById(R.id.recipe_reviews);
        ImageView recipePic = (ImageView) view.findViewById(R.id.recipe_pic);

        recipeName.setText(recipe.getSmoothieName());
        recipeDescription.setText(recipe.getDescription());

        recipeIngredientsList = recipe.getIngredients();
        recipeReviewsList = recipe.getReviews();


        for(int i = 0; i < recipeIngredientsList.length; i++) {
            recipeIngredients.setText(recipeIngredients.getText() + "\u26AB " + recipeIngredientsList[i] + "\n");
        }

        recipePic.setImageResource(recipe.getPhotoID());
        initGetReviews(recipeReviewsList);

    }

    public void initNewReview() {
        Button submitBtn = (Button) view.findViewById(R.id.submit_button);
        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                latestRating = (RatingBar)getActivity().findViewById(R.id.recipe_rating);
                latestReview = (EditText)getActivity().findViewById(R.id.recipe_rating_text);

                currentReviewString = latestReview.getText().toString();
                int numStars = (int)latestRating.getRating();


                if(!(latestReview.equals("") || latestReview.equals(null) || latestRating.equals("") || latestRating.equals(null) )) {
                    for(int i = 1; i <=numStars; i++) {
                        starValues += "\u2605";
                    }

                    if(numStars<5){
                        numEmptyStars = 5 - numStars;

                        for(int i=1; i<=numEmptyStars; i++){
                            starValues += "\u2606";
                        }
                    }

                    String fullLatestReview = starValues + "\n" + currentReviewString;

                    ArrayList<String> addedRecipeReviews = new ArrayList<>(Arrays.asList(recipeReviewsList));

                    addedRecipeReviews.add(fullLatestReview);

                    String[] newReview = addedRecipeReviews.toArray(new String[addedRecipeReviews.size()]);
                    recipe.setReviews(newReview);
                    recipeReviews.setText(recipeReviews.getText() + fullLatestReview + "\n");
                    starValues = "";


                }
            }
        });
    }

    public void initGetReviews(String[] recipeReviews){
        TextView recipeUpdatedReviews = (TextView)view.findViewById(R.id.recipe_reviews);
        for(int i = 0; i < recipeReviews.length; i++) {
            recipeUpdatedReviews.setText(recipeUpdatedReviews.getText() + recipeReviews[i] + "\n");
        }

    }
}

