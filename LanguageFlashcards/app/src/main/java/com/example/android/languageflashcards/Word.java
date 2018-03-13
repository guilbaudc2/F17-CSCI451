package com.example.android.languageflashcards;

/**
 * Created by Android on 10/28/2017.
 */

public class Word {
    private String language;
    private String word;
    private String part_of_speech;
    private String definition;

    public Word(String language, String word, String part_of_speech, String definition) {
        this.language = language;
        this.word = word;
        this.part_of_speech = part_of_speech;
        this.definition = definition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPart_of_speech() {
        return part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
