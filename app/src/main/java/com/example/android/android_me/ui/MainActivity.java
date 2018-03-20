package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_INDEX = "head_index";
    public static final String BODY_INDEX = "body_index";
    public static final String LEG_INDEX = "leg_index";
    public static final String INDEXES = "indexes";

    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    private Intent mIntent;
    private Button mButton;
    private Bundle bundle;
    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.next_button);
        if(findViewById(R.id.lanscape_linear) != null){
            mDualPane = true;
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            mButton.setVisibility(View.GONE);
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
        else{
            mDualPane = false;
            mIntent = new Intent(this, AndroidMeActivity.class);
            bundle = new Bundle();
            mIntent.putExtra(INDEXES, bundle);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(mIntent);
                }
            });
        }
    }

    @Override
    public void onImageSelected(int position) {
        if(mDualPane){
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            switch (position / 12){
                case 0:
                    bodyPartFragment.setImageIDs(AndroidImageAssets.getHeads());
                    bodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, bodyPartFragment)
                            .commit();
                    break;
                case 1:
                    bodyPartFragment.setImageIDs(AndroidImageAssets.getBodies());
                    bodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, bodyPartFragment)
                            .commit();
                    break;
                case 2:
                    bodyPartFragment.setImageIDs(AndroidImageAssets.getLegs());
                    bodyPartFragment.setListIndex(position % 12);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, bodyPartFragment)
                            .commit();
                    break;
                default:
                    Toast.makeText(this, "Unknown image clicked " + (position / 12), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            switch (position / 12) {
                case 0:
                    headIndex = position % 12;
                    bundle.putInt(HEAD_INDEX, headIndex);
                    break;
                case 1:
                    bodyIndex = position % 12;
                    bundle.putInt(BODY_INDEX, bodyIndex);
                    break;
                case 2:
                    legIndex = position % 12;
                    bundle.putInt(LEG_INDEX, legIndex);
                    break;
                default:
                    Toast.makeText(this, "Unknown image clicked " + (position / 12), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
