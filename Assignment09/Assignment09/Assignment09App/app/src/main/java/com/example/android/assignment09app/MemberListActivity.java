package com.example.android.assignment09app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemberListActivity extends SingleFragmentActivity implements MemberListFragment.Callbacks, MemberDetailFragment.Callbacks{

    @Override
    protected Fragment createFragment() {
        return new MemberListFragment();
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_master_layout;
    }

    @Override
    public void onMemberSelected(int memberID) {
        //portrait
        if(findViewById(R.id.details_fragment_container) == null){
            Intent intent = MemberPagerActivity.newIntent(this, memberID);
            startActivity(intent);
        }
        else {//landscape/tablet
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment oldFragment = manager.findFragmentById(R.id.details_fragment_container);
            Fragment newFragment = MemberDetailFragment.newInstance(memberID);

            if(oldFragment != null){
                transaction.remove(oldFragment);
            }

            transaction.add(R.id.details_fragment_container, newFragment);
            transaction.commit();

        }
    }

    @Override
    public void onMemberUpdated(int memberID) {
        FragmentManager manager = getSupportFragmentManager();
        MemberListFragment listFragment = (MemberListFragment)
                manager.findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
