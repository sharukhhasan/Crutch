package com.sharukhhasan.studycrutch.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharukhhasan.studycrutch.R;

/**
 * Created by sharukhhasan on 6/7/16.
 */
public class CourseFiveFragment extends Fragment {

    public CourseFiveFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        return rootView;
    }
}
