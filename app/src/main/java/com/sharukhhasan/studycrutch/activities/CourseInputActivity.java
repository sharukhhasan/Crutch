package com.sharukhhasan.studycrutch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.facebook.internal.CollectionMapper;
import com.sharukhhasan.studycrutch.AppController;
import com.sharukhhasan.studycrutch.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class CourseInputActivity extends AppCompatActivity {
    public static final String TAG = "CourseInputActivity";
    private ImageButton btnAdd;
    private Spinner courses;
    private Map<String, ArrayList<String>> coursesMap = AppController.courseMap;
    private ArrayList<String> coursesList = AppController.courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                LinearLayout newLinear = new LinearLayout(CourseInputActivity.this);
                Spinner newSpinner = new Spinner(CourseInputActivity.this);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CourseInputActivity.this, R.array.coursesArray, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                newSpinner.setAdapter(adapter);
                newLinear.addView(newSpinner);
                setContentView(newLinear);
            }
        });
    }


}
