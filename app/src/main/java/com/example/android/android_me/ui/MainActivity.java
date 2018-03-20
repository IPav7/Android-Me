package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_INDEX = "head_index";
    public static final String BODY_INDEX = "body_index";
    public static final String LEG_INDEX = "leg_index";
    public static final String INDEXES = "indexes";

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    Intent mIntent;
    Button mButton;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.next_button);
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

    @Override
    public void onImageSelected(int position) {
        switch (position/12){
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
            default: Toast.makeText(this, "Unknown image clicked " + (position/12), Toast.LENGTH_SHORT).show();
        }

    }
}
