package com.example.android.landlayapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;
import static android.content.Intent.getIntent;
import static com.example.android.landlayapplication.BookDetailFragment.DETAIL_SPOILED;
import static com.example.android.landlayapplication.BookDetailFragment.SPOILER;
import static com.example.android.landlayapplication.BookDetailFragment.TITLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookSpoilerFragment extends Fragment {
    View view;
    String bookSpoiler;
    String bookTitle;
    public static final int YOU_SPOILED_IT = 1;

    String spoiledIT = "You spoiled it!!";


    public BookSpoilerFragment() {
        // Required empty public constructor
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(SPOILER, bookSpoiler);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            bookSpoiler = savedInstanceState.getString(SPOILER, bookSpoiler);
        }
        setRetainInstance(true);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            bookSpoiler = savedInstanceState.getString(SPOILER, bookSpoiler);
        }
        view = inflater.inflate(R.layout.fragment_book_spoiler, container, false);
        initShowSpoiler();

        return view;
    }

    public void initShowSpoiler(){
        Button setSpoilerBtn = (Button)view.findViewById(R.id.btn_proceed);
        TextView spoilerTitle = (TextView)view.findViewById(R.id.spoiler_title);
        bookTitle = getActivity().getIntent().getStringExtra(TITLE);
        spoilerTitle.setText(bookTitle);
        bookSpoiler = getActivity().getIntent().getStringExtra(SPOILER);
        final TextView spoilerText = (TextView)view.findViewById(R.id.spoiler_text);

        final String finalBookSpoiler = bookSpoiler;
        setSpoilerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View localView) {
                Intent intent = new Intent();
                intent.putExtra(String.valueOf(DETAIL_SPOILED),1);
                getActivity().setResult(YOU_SPOILED_IT, intent);
//                TextView youSpoiled = (TextView)view.findViewById(R.id.spoiled);
//                youSpoiled.setText("You spoiled it, silly!");
                spoilerText.setText(finalBookSpoiler);
            }
        });



    }

}
