package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavin on 20.03.2018.
 */

public class BodyPartFragment extends Fragment {

    private static final String LIST_OF_IMAGES = "list_of_images";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIDs;
    private int mListIndex;

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_body_part, container, false);
        if(savedInstanceState != null){
            mImageIDs = savedInstanceState.getIntegerArrayList(LIST_OF_IMAGES);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        final ImageView imageView = root.findViewById(R.id.body_part_image_view);
        if(mImageIDs!=null)
        imageView.setImageResource(mImageIDs.get(mListIndex));
        else
            Log.v("MY TAG", "no image ids");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListIndex < mImageIDs.size()-1)
                    mListIndex++;
                else mListIndex = 0;
                imageView.setImageResource(mImageIDs.get(mListIndex));
            }
        });
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(LIST_OF_IMAGES, (ArrayList<Integer>) mImageIDs);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public void setImageIDs(List<Integer> imageIDs) {
        mImageIDs = imageIDs;
    }

    public void setListIndex(int listIndex) {
        mListIndex = listIndex;
    }
}
