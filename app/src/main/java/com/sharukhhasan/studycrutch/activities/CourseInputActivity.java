package com.sharukhhasan.studycrutch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.sharukhhasan.studycrutch.AppController;
import com.sharukhhasan.studycrutch.R;

import java.util.ArrayList;
import java.util.Map;

import info.hoang8f.widget.FButton;

public class CourseInputActivity extends AppCompatActivity implements OnItemSelectedListener{
    public static final String TAG = "CourseInputActivity";
    private AppController controller = (AppController)getApplication();
    private FButton btnAdd;
    private FButton btnDone;
    private Spinner deptSpinner;
    private Spinner courseSpinner;
    private ArrayList<String> deptList;
    private ArrayList<String> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);

        deptList = controller.getEngrDepts();
        String[] courseArray = courseList.toArray(new String[courseList.size()]);
        ArrayAdapter<CharSequence> deptAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, courseArray);

        deptSpinner = (Spinner) findViewById(R.id.courseSpinner);
        deptSpinner.setAdapter(deptAdapter);
        deptSpinner.setOnItemSelectedListener(this);

        courseSpinner = (Spinner) findViewById(R.id.courseSpinner);

        btnAdd = (FButton) findViewById(R.id.addCourseBtn);
        btnAdd.setButtonColor(R.color.apporange);
        btnAdd.setShadowHeight(8);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

        btnDone = (FButton) findViewById(R.id.finishedBtn);
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
        String item = parent.getItemAtPosition(position).toString();
        Map<String, ArrayList<String>> courseMap = controller.getEngrCourseMap();
        courseList = courseMap.get(item);
        String[] courseArray = courseList.toArray(new String[courseList.size()]);
        ArrayAdapter<CharSequence> courseAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, courseArray);
        courseSpinner.setAdapter(courseAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
