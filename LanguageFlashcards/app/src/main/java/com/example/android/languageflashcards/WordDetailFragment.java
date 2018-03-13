package com.example.android.languageflashcards;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordDetailFragment extends Fragment {
    Word word;
    private static final String ARGS_WORD_ID = "word_id";
    View view;
    TextView wordName;
    TextView wordPOS;
    TextView wordDefinition;


    public WordDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int wordID = (int) getArguments().getInt(ARGS_WORD_ID);
        word = WordSet.getWordSet().getLanguageWord(wordID);
    }

    public static WordDetailFragment newInstance(int wordID) {
        Bundle args = new Bundle();
        args.putInt(ARGS_WORD_ID, wordID);
        WordDetailFragment fragment = new WordDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_word_detail, container, false);
        initWordDetails();
        initShowDefBtn();
        return view;
    }

    public void initWordDetails() {
        wordName = (TextView) view.findViewById(R.id.word_name);
        wordPOS = (TextView) view.findViewById(R.id.word_pos);
        wordDefinition = (TextView) view.findViewById(R.id.word_definition);

        wordName.setText(word.getWord());
    }

    public void initShowDefBtn(){
        final Button showBtn = (Button)view.findViewById(R.id.show_button);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtn.setText(R.string.hide_def);
                wordPOS.setText(word.getPart_of_speech());
                wordDefinition.setText(word.getDefinition());


            }
        });
    }
}
