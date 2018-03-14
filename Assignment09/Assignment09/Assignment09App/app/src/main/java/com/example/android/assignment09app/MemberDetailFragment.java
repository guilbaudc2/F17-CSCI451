package com.example.android.assignment09app;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberDetailFragment extends Fragment {
    Member member;
    View view;
    int memberID;
    private Callbacks callbacks;
    MediaPlayer song;
    Button playBtn;

    private static final String ARGS_MEMBER_ID = "member_id";

    public interface Callbacks {
        void onMemberUpdated(int memberID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public MemberDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        memberID = (int)getArguments().getInt(ARGS_MEMBER_ID);
        member = MemberSet.getMemberSet().getMember(memberID);
    }

    public static MemberDetailFragment newInstance(int memberID){
        Bundle args = new Bundle();
        args.putInt(ARGS_MEMBER_ID, memberID);
        MemberDetailFragment fragment = new MemberDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_member_detail, container, false);
        song = MediaPlayer.create(getActivity(), member.getSoloSong());
        initStageNameTV();
        initNameTV();
        initBirthDateTV();
        initAgeTV();
        initSoloSong();
        initSoloSongTV();
        initMemberDescription();
        return view;
    }


    private void initStageNameTV(){
        final TextView stageName = (TextView)view.findViewById(R.id.member_stage_name);
        stageName.setText(member.getStageName());
    }

    private void initNameTV(){
        TextView realName = (TextView)view.findViewById(R.id.member_real_name);
        realName.setText("Real name: " + member.getRealName());
    }

    public void initBirthDateTV(){
        TextView birthDate = (TextView)view.findViewById(R.id.member_birth_date);
        birthDate.setText("Birthdate: " +member.getBirthDate());
    }

    private void initAgeTV(){
        TextView memberAge = (TextView)view.findViewById(R.id.member_age);
        memberAge.setText("Current Age: " + member.getAge());

    }


    private void initSoloSong(){
        playBtn = (Button) view.findViewById(R.id.member_song);
        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if(song.isPlaying()){
                    playBtn.setText(R.string.play_song);
                    song.pause();
                } else {
                    playBtn.setText(R.string.stop_song);
                    song.start();
                }

            }
        });

    }

    public void initSoloSongTV(){
        TextView soloSongTitle = (TextView)view.findViewById(R.id.member_song_title);
        soloSongTitle.setText("Solo Song from the Wings/You Never Walk Alone Album: " + member.getSoloSongTitle());
    }


    public void initMemberDescription() {
        ImageView descBtn = (ImageView) view.findViewById(R.id.member_pic);
        final TextView memberDescription = (TextView) view.findViewById(R.id.member_description);
        descBtn.setImageResource(member.getPhotoID());
        descBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                memberDescription.setText(member.getDescription());
            }
        });
    }

}

