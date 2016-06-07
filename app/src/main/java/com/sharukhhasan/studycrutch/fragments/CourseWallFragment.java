package com.sharukhhasan.studycrutch.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sharukhhasan.studycrutch.R;

/**
 * Created by sharukhhasan on 6/7/16.
 */
public class CourseWallFragment extends Fragment {
    EditText insertPost;
    Button createPost;
    ListView wallPosts;

    public static CourseWallFragment newInstance()
    {
        CourseWallFragment courseWallFragment = new CourseWallFragment();
        return courseWallFragment;
    }

    public CourseWallFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_coursewall, container, false);

        insertPost = (EditText) rootView.findViewById(R.id.insert_post);

        createPost = (Button) rootView.findViewById(R.id.createBtn);
        createPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        wallPosts = (ListView) rootView.findViewById(R.id.posts_list);

        return rootView;
    }
}