package com.example.android.android_me.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Bundle bundle = getIntent().getBundleExtra(MainActivity.INDEXES);
        int headIndex = bundle.getInt(MainActivity.HEAD_INDEX, 0);
        int bodyIndex = bundle.getInt(MainActivity.BODY_INDEX, 0);
        int legIndex = bundle.getInt(MainActivity.LEG_INDEX, 0);
        if(savedInstanceState == null) {
            BodyPartFragment headPartFragment = new BodyPartFragment();
            headPartFragment.setImageIDs(AndroidImageAssets.getHeads());
            headPartFragment.setListIndex(headIndex);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headPartFragment)
                    .commit();
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setImageIDs(AndroidImageAssets.getBodies());
            bodyPartFragment.setListIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyPartFragment)
                    .commit();
            BodyPartFragment legPartFragment = new BodyPartFragment();
            legPartFragment.setImageIDs(AndroidImageAssets.getLegs());
            legPartFragment.setListIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legPartFragment)
                    .commit();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(this, "changed", Toast.LENGTH_SHORT).show();
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
        }
    }
}
