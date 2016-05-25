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
    private Spinner depts;
    private Spinner courses;
    private Map<String, ArrayList<String>> coursesMap;
    private ArrayList<String> deptList;
    private AppController controller = new AppController();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);

        coursesMap = controller.getCourses();
        deptList = controller.getEngrDepts();
        String[] deptArray = deptList.toArray(new String[deptList.size()]);
        ArrayAdapter<CharSequence> deptAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, deptArray);

        depts = (Spinner) findViewById(R.id.departmentSpinner);
        depts.setAdapter(deptAdapter);

        courses = (Spinner) findViewById(R.id.courseSpinner);


    }


}
