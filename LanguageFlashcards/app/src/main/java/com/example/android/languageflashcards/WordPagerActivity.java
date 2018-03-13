package com.example.android.languageflashcards;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class WordPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Word> wordList;
    int startID;
    int stopID;

    public static final String EXTRA_VOCAB_ID = "word_ID";

    public static Intent newIntent(Context packageContext, int wordID) {
        Intent intent = new Intent(packageContext, WordPagerActivity.class);
        intent.putExtra(EXTRA_VOCAB_ID, wordID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_pager);
        int wordID = (int) getIntent().getIntExtra(EXTRA_VOCAB_ID, 0);
        if(wordID == 0){
            startID = 0;
            stopID = 4;
        }
        if(wordID == 5){
            startID = 5;
            stopID = 9;
        }
        if(wordID == 10){
            startID = 10;
            stopID = 14;
        }

        viewPager = (ViewPager) findViewById(R.id.word_pager);
        wordList = WordSet.getWordSet().getLanguageWordList(startID, stopID+1);

        FragmentManager manager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentPagerAdapter(manager) {
                 @Override
                 public Fragment getItem(int position) {
                     return WordDetailFragment.newInstance(position);
                 }

                 @Override
                 public int getCount() {
                     return wordList.size();
                 }
             }
        );

        //initialize the pager begin
        viewPager.setCurrentItem(0);


    }
}
