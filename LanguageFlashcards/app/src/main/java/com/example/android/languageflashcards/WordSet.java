package com.example.android.languageflashcards;

import java.util.ArrayList;

/**
 * Created by Android on 10/28/2017.
 */

public class WordSet {
    private static WordSet wordSet;
    private ArrayList<Word> wordList = new ArrayList<Word>();
    private ArrayList<Word> languageWordList;

    private WordSet() {
        wordList.add(new Word("French", "Le Gateau", "noun - m.", "English Translation: The Cake"));
        wordList.add(new Word("French", "Le Cadeau", "noun - m.", "English Translation: The Gift"));
        wordList.add(new Word("French", "La Chanson", "noun - f.", "English Translation: The Song"));
        wordList.add(new Word("French", "Penser", "verb", "English Translation: To think"));
        wordList.add(new Word("French", "J'ai faim.", "sentence/phrase", "English Translation: I\'m hungry."));

        wordList.add(new Word("German", "Entschuldigen", "verb", "English Translation: Excuse me"));
        wordList.add(new Word("German", "Gedacht", "adjective", "English Translation: Thought"));
        wordList.add(new Word("German", "Danke schön", "sentence/phrase", "English Translation: Thank you"));
        wordList.add(new Word("German", "Die Katze", "noun - f.", "English Translation: The Cat"));
        wordList.add(new Word("German", "Das Auto", "noun - n.", "English Translation: The Car"));

        wordList.add(new Word("Korean", "생각하다", "verb", "English Translation: To think. \n\nPronounced Sang-gahk-ha-da"));
        wordList.add(new Word("Korean", "고양이", "noun", "English Translation: Cat. \n\nPronounced Go-yang-ee"));
        wordList.add(new Word("Korean", "감사합니다", "sentence/phrase", "English Translation: Thank you. \n\nPronounced Kahm-sa-ha-mnee-da"));
        wordList.add(new Word("Korean", "안녕하세요", "sentence/phrase", "English Translation: Hello. \n\nPronounced Ahn-young-ha-say-yo"));
        wordList.add(new Word("Korean", "사과", "noun", "English Translation: 1) Apple (the fruit). 2) Apology. \n\nPronounced Sa-gwa"));
        
    }

    public static WordSet getWordSet(){
        if(wordSet == null){
            wordSet = new WordSet();
        }
        return wordSet;
    }

    public ArrayList<Word> getLanguageWordList(int start, int stop){
        languageWordList = new ArrayList<Word>(wordList.subList(start, stop));
        return languageWordList;
    }

    public Word getLanguageWord(int id){
        if(id < 0 || id >= languageWordList.size())return null;
            return languageWordList.get(id);

    }
}
