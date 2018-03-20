package com.example.android.android_me.ui;

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

import java.util.List;

/**
 * Created by pavin on 20.03.2018.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIDs;
    private int mListIndex;

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = root.findViewById(R.id.body_part_image_view);
        if(mImageIDs!=null)
        imageView.setImageResource(mImageIDs.get(mListIndex));
        else
            Log.v("MY TAG", "no image ids");
        return root;
    }

    public void setImageIDs(List<Integer> imageIDs) {
        mImageIDs = imageIDs;
    }

    public void setListIndex(int listIndex) {
        mListIndex = listIndex;
    }
}
