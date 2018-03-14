package com.example.android.assignment11;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;

    public static final String RECIPE_ID = "recipe_id";

    public RecipeListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_recipe_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        updateUI();
        initFAB();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI(){
        RecipeSet recipeSet = RecipeSet.getList(getActivity());
        List<Recipe> recipes = recipeSet.getRecipes();

        if(adapter == null){
            adapter = new RecipeAdapter(recipes);
            recyclerView.setAdapter(adapter);
        }
        else {
            adapter.setRecipes(recipes);
            adapter.notifyDataSetChanged();
        }
    }

    private class RecipeHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private TextView tvRecipeName;
        private ImageView ivPicture;
        private int recipeID;
        private Recipe recipe;


        public RecipeHolder(View itemView) {
            super(itemView);
            tvRecipeName = (TextView)itemView.findViewById(R.id.tv_list_recipe_name);
            ivPicture = (ImageView) itemView.findViewById(R.id.iv_list_pic);
            itemView.setOnClickListener(this);
        }

        public void setRecipeID(int recipeID){
            this.recipeID = recipeID;
        }

        public void bindRecipe(Recipe recipe)
        {
            this.recipe = recipe;
            tvRecipeName.setText(recipe.getSmoothieName());
            byte[] outImage= recipe.getSmoothieImage();
            if (outImage != null) {

                ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
                Bitmap bmp = BitmapFactory.decodeStream(imageStream);
                ivPicture.setImageBitmap(bmp);
            }

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), RecipePagerActivity.class);
            intent.putExtra(RECIPE_ID,recipe.getId());
            startActivity(intent);
        }
    }


    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder>{
        private List<Recipe> recipes;

        public RecipeAdapter(List<Recipe> recipes) {
            this.recipes = recipes;
        }

        @Override
        public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View viewRH = inflater.inflate(R.layout.list_item_recipe, parent, false);
            return new RecipeHolder(viewRH);
        }

        @Override
        public void onBindViewHolder(RecipeHolder holder, int position) {
            Recipe recipe = recipes.get(position);
            holder.tvRecipeName.setText(recipe.getSmoothieName());
            byte[] outImage= recipe.getSmoothieImage();
            if (outImage != null) {
                Bitmap bmp = BitmapFactory.decodeByteArray(recipe.getSmoothieImage(), 0, recipe.getSmoothieImage().length);
                holder.ivPicture.setImageBitmap(bmp);
            }
            holder.bindRecipe(recipe);
        }

        @Override
        public int getItemCount() {
            return recipes.size();
        }
        public void setRecipes(List<Recipe> recipes)
        {
            this.recipes = recipes;
        }
    }

    public void initFAB(){
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab_item_new_recipe);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Recipe recipe = new Recipe();
                RecipeSet.getList(getActivity()).addRecipe(recipe);
                Intent intent = new Intent(getActivity(), RecipePagerActivity.class);
                intent.putExtra(RECIPE_ID, recipe.getId());
                startActivity(intent);

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
