package com.example.android.smoothierecipeapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_recipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        RecipeSet recipeSet = RecipeSet.getRecipeSet();
        List<Recipe> recipes = recipeSet.getRecipes();
        adapter = new RecipeAdapter(recipes);
        recyclerView.setAdapter(adapter);
    }

    private class RecipeHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        private TextView tvRecipeName;
        private ImageView ivPicture;
        private int recipeID;


        public RecipeHolder(View itemView) {
            super(itemView);
            tvRecipeName = (TextView)itemView.findViewById(R.id.tv_list_recipe_name);
            ivPicture = (ImageView)itemView.findViewById(R.id.iv_list_picture);
            itemView.setOnClickListener(this);
        }

        public void setRecipeID(int recipeID){
            this.recipeID = recipeID;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
            intent.putExtra(RECIPE_ID,recipeID);
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
            holder.ivPicture.setImageResource(recipe.getPhotoID());
            holder.setRecipeID(position);
        }

        @Override
        public int getItemCount() {
            return recipes.size();
        }
    }
}
