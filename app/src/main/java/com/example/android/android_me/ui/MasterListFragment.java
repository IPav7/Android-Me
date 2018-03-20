package com.example.android.android_me.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by pavin on 20.03.2018.
 */

public class MasterListFragment extends Fragment {

    MasterListAdapter mMasterListAdapter;
    OnImageClickListener mOnImageClickListener;

    public MasterListFragment(){

    }

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnImageClickListener)
            mOnImageClickListener = (OnImageClickListener)activity;
        else throw new ClassCastException("activity must implement OnImageClickListener");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = root.findViewById(R.id.images_grid_view);
        mMasterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mMasterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mOnImageClickListener.onImageSelected(position);
            }
        });
        return root;
    }
}
