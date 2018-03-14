package com.example.android.assignment09app;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View view;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        MediaPlayer song = MediaPlayer.create(getActivity(), R.raw.allbloodsweattears);
        song.start();

        initButtonProceed();

        return view;
    }


    public void initButtonProceed() {
        ImageButton proceedBtn = (ImageButton) view.findViewById(R.id.imageProceedBtn);
        proceedBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MemberListActivity.class);
                startActivity(intent);
            }
        });
    }
}
