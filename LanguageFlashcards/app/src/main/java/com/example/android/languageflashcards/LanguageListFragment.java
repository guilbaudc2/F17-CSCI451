package com.example.android.languageflashcards;



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

import java.util.ArrayList;
import java.util.List;

public class LanguageListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    ArrayList<String> languages = new ArrayList<String>();
    ArrayList<String> languageDescription = new ArrayList<String>();
    ArrayList<Integer> languageImages = new ArrayList<Integer>();

    public LanguageListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_language_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_language_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        languages.add("French");
        languages.add("German");
        languages.add("Korean");
        languageImages.add(R.drawable.flagfr);
        languageImages.add(R.drawable.flagger);
        languageImages.add(R.drawable.flagsk);
        languageDescription.add("Study key words and phrases from the French language");
        languageDescription.add("Study key words and phrases from the German language");
        languageDescription.add("Study key words and phrases from the Korean language");
        updateUI();
        return view;
    }

    private void updateUI(){
        adapter = new CategoryAdapter(languages, languageImages);
        recyclerView.setAdapter(adapter);
    }

    private class CategoryHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        private TextView tvCatName;
        private ImageView ivCatPic;
        private TextView tvCatDesc;
        private int wordID;

        public CategoryHolder(View itemView) {
            super(itemView);

            tvCatName = (TextView)itemView.findViewById(R.id.tv_list_cat_name);
            ivCatPic = (ImageView)itemView.findViewById(R.id.iv_cat_pic);
            tvCatDesc = (TextView)itemView.findViewById(R.id.tv_list_cat_desc);
            itemView.setOnClickListener(this);
        }

        public void setWordID(int wordID){
            this.wordID = wordID;
        }

        @Override
        public void onClick(View view) {
            Intent intent = WordPagerActivity.newIntent(getActivity(), wordID);
            startActivity(intent);
        }
    }


    private class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder>{
        private List<String> languages;
        private List<Integer> languagesImages;

        public CategoryAdapter(List<String> languages, List<Integer> languagesImages) {
            this.languages = languages;
            this.languagesImages = languagesImages;
        }


        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View viewCH = inflater.inflate(R.layout.list_item_word, parent, false);
            return new CategoryHolder(viewCH);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {
            String language = languages.get(position);

            holder.tvCatName.setText(languages.get(position));
            holder.ivCatPic.setImageResource(languagesImages.get(position));
            holder.tvCatDesc.setText(languageDescription.get(position));
            if (languages.get(position) == "French") {
                holder.setWordID(0);
            } else if (languages.get(position) == "German"){
                holder.setWordID(5);
            }else {
                holder.setWordID(10);
            }
        }

        @Override
        public int getItemCount() {
            return languages.size();
        }

    }
}
