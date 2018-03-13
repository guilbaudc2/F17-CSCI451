package com.example.android.landlayapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookIntroFragment extends Fragment {
    View view;

    public BookIntroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_book_intro, container, false);
        initButtonProceed();

        return view;
    }


    public void initButtonProceed(){
        ImageButton proceedBtn  = (ImageButton)view.findViewById(R.id.imageProceedBtn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookViewActivity.class);
                startActivity(intent);
            }
        });
    }
}