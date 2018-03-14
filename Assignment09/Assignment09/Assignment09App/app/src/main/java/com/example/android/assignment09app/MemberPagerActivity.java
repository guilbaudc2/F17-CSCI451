package com.example.android.assignment09app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MemberPagerActivity extends AppCompatActivity implements MemberDetailFragment.Callbacks{
    private ViewPager viewPager;
    private List<Member> members;

    public static final String EXTRA_MEMBER_ID = "member_ID";

    public static Intent newIntent (Context packageContext, int memberID){
        Intent intent = new Intent(packageContext, MemberPagerActivity.class);
        intent.putExtra(EXTRA_MEMBER_ID, memberID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_pager);

        int memberID = (int)getIntent().getIntExtra(EXTRA_MEMBER_ID,0);

        viewPager = (ViewPager)findViewById(R.id.member_pager);
        members = MemberSet.getMemberSet().getMembers();

        FragmentManager manager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentPagerAdapter(manager) {
                                 @Override
                                 public Fragment getItem(int position) {
                                     return MemberDetailFragment.newInstance(position);
                                 }

                                 @Override
                                 public int getCount() {
                                     return members.size();
                                 }
                             }
        );

        //initialize the pager begin
        viewPager.setCurrentItem(memberID);



    }

    @Override
    public void onMemberUpdated(int memberID) {}

}
