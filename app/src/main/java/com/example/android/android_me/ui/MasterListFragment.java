package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by pavin on 20.03.2018.
 */

public class MasterListFragment extends Fragment {

    MasterListAdapter mMasterListAdapter;

    public MasterListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = root.findViewById(R.id.images_grid_view);
        mMasterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mMasterListAdapter);
        return root;
    }
}
