package com.sharukhhasan.studycrutch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.sharukhhasan.studycrutch.AppController;
import com.sharukhhasan.studycrutch.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import info.hoang8f.widget.FButton;

import butterknife.BindView;

public class CourseInputActivity extends AppCompatActivity implements OnItemSelectedListener{
    public static final String TAG = "CourseInputActivity";

    @BindView(R.id.addCourseBtn)
    private FButton btnAdd;

    @BindView(R.id.finishedBtn)
    private FButton btnDone;

    @BindView(R.id.courseSpinner)
    private Spinner mSpinner;

    private ArrayList<String> courseList;
    private AppController controller = new AppController();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);
        ButterKnife.bind(this);

        courseList = controller.getEngrCourses();
        String[] courseArray = courseList.toArray(new String[courseList.size()]);
        ArrayAdapter<CharSequence> courseAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, courseArray);
        mSpinner = (Spinner) findViewById(R.id.courseSpinner);
        mSpinner.setAdapter(courseAdapter);
        mSpinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);



        //btnAdd = (FButton) findViewById(R.id.addCourseBtn);
        btnAdd.setButtonColor(R.color.apporange);
        btnAdd.setShadowHeight(8);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

        //btnDone = (FButton) findViewById(R.id.finishedBtn);
        btnDone.setButtonColor(R.color.apporange);
        btnDone.setShadowHeight(8);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CourseInputActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        mSpinner.setSelection(position);
        String selectedCourse = (String) mSpinner.getSelectedItem();
        mSpinner.setText(selectedCourse);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
