package com.example.android.landlayapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Intent.getIntent;
import static com.example.android.landlayapplication.BookDetailFragment.SPOILER;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookSpoilerFragment extends Fragment {
    View view;
    String bookSpoiler;


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
        bookSpoiler = getActivity().getIntent().getStringExtra(SPOILER);
//        String bookSpoiler = getArguments().getString(SPOILER);
        final TextView spoilerText = (TextView)view.findViewById(R.id.spoiler_text);

//        if(bundle != null) {
//            bookSpoiler = bundle.getString(SPOILER);
//        }else{
//            bookSpoiler = "I am null for some reason.";
//        }
        final String finalBookSpoiler = bookSpoiler;
        setSpoilerBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View localView) {
                spoilerText.setText(finalBookSpoiler);

            }
        });



    }

}
