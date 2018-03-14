package com.example.android.assignment10;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;

    public static final String RECIPE_ID = "recipe_id";

    private Callbacks callbacks;

    public interface Callbacks {
        void onRecipeSelected(UUID recipeID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
    
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
        private Recipe recipe;
        private UUID recipeID;


        public RecipeHolder(View itemView) {
            super(itemView);
            tvRecipeName = (TextView)itemView.findViewById(R.id.tv_list_recipe_name);
            itemView.setOnClickListener(this);
        }

        public void bindRecipe(Recipe recipe)
        {
            this.recipe = recipe;
            tvRecipeName.setText(recipe.getSmoothieName());
        }

        @Override
        public void onClick(View view) {
            callbacks.onRecipeSelected(recipe.getId());
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_recipe_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.menu_item_new_recipe:
                Recipe recipe = new Recipe();
                RecipeSet.getList(getActivity()).addRecipe(recipe);
                Intent intent = new Intent(getActivity(), RecipePagerActivity.class);
                intent.putExtra(RECIPE_ID, recipe.getId());
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
