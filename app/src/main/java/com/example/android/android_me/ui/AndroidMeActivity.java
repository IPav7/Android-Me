package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        BodyPartFragment headPartFragment = new BodyPartFragment();
        headPartFragment.setImageIDs(AndroidImageAssets.getHeads());
        headPartFragment.setListIndex(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headPartFragment)
                .commit();
        BodyPartFragment bodyPartFragment = new BodyPartFragment();
        bodyPartFragment.setImageIDs(AndroidImageAssets.getBodies());
        bodyPartFragment.setListIndex(0);
        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyPartFragment)
                .commit();
        BodyPartFragment legPartFragment = new BodyPartFragment();
        legPartFragment.setImageIDs(AndroidImageAssets.getLegs());
        legPartFragment.setListIndex(0);
        fragmentManager.beginTransaction()
                .add(R.id.leg_container, legPartFragment)
                .commit();
    }
}
