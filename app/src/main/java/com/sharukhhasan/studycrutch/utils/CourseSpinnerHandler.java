package com.sharukhhasan.studycrutch.utils;

import android.view.View;
import android.widget.AdapterView;

import com.sharukhhasan.studycrutch.activities.CourseInputActivity;

/**
 * Created by sharukhhasan on 5/20/16.
 */
public class CourseSpinnerHandler implements AdapterView.OnItemSelectedListener {

    private boolean isFirst = true;
    private CourseInputActivity regCourses;

    public CourseSpinnerHandler(CourseInputActivity activity)
    {

        this.regCourses = activity;
    }

    /** This method will invoke when an entry is selected. Invoked once
     when Spinner is first displayed, then again for each time the user selects something
     */
    @Override
    public void onItemSelected(AdapterView<?> spinner, View selectedView, int selectedIndex, long id)
    {
        // Do not want to display the toast while the activity first loaded.
        if(isFirst)
        {
            isFirst = false;
        }
        else
        {
            String selection = spinner.getItemAtPosition(selectedIndex).toString();
            //String message =
            //String.format(mItemSelectedMessageTemplate, selection);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
