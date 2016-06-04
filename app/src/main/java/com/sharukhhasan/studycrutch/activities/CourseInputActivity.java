package com.sharukhhasan.studycrutch.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dd.morphingbutton.MorphingButton;
import com.sharukhhasan.studycrutch.R;

public class CourseInputActivity extends AppCompatActivity {
    private int mMorphCounter1 = 1;
    private int mMorphCounter2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);

        Spinner deptSpinner = (Spinner) findViewById(R.id.deptSpinner);

        ArrayAdapter<CharSequence> deptAdapter = ArrayAdapter.createFromResource(this, R.array.deptArray, android.R.layout.simple_spinner_item);
        deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deptSpinner.setAdapter(deptAdapter);

        Spinner dynamicSpinner = (Spinner) findViewById(R.id.courseSpinner);

        final MorphingButton btnMorph1 = (MorphingButton) findViewById(R.id.addCourseBtn);
        btnMorph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMorphButton1Clicked(btnMorph1);
            }
        });

        final MorphingButton btnMorph2 = (MorphingButton) findViewById(R.id.finishedBtn);
        btnMorph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMorphButton2Clicked(btnMorph2);
            }
        });

        morphToSquare1(btnMorph1, 0);
        morphToFailure(btnMorph2, 0);

    }

    private void onMorphButton1Clicked(final MorphingButton btnMorph)
    {
        if(mMorphCounter1 == 0)
        {
            mMorphCounter1++;
            morphToSquare1(btnMorph, R.integer.mb_animation);
        }
        else if(mMorphCounter1 == 1)
        {
            mMorphCounter1 = 0;
            morphToSuccess(btnMorph);
        }
    }

    private void onMorphButton2Clicked(final MorphingButton btnMorph)
    {
        if(mMorphCounter2 == 0)
        {
            mMorphCounter2++;
            morphToFailure(btnMorph, R.integer.mb_animation);
        }
        else if(mMorphCounter2 == 1)
        {
            mMorphCounter2 = 0;
            morphToSquare2(btnMorph, R.integer.mb_animation);
        }
    }

    private void morphToSquare1(final MorphingButton btnMorph, int duration)
    {
        MorphingButton.Params square = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(R.dimen.mb_corner_radius_2)
                .width(R.dimen.mb_width_200)
                .height(R.dimen.mb_height_56)
                .color(R.color.apporange)
                .colorPressed(R.color.apporangeDark)
                .text(getString(R.string.add_course));
        btnMorph.morph(square);
    }

    private void morphToSquare2(final MorphingButton btnMorph, int duration)
    {
        MorphingButton.Params square = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(R.dimen.mb_corner_radius_2)
                .width(R.dimen.mb_width_200)
                .height(R.dimen.mb_height_56)
                .color(R.color.apporange)
                .colorPressed(R.color.apporangeDark)
                .text(getString(R.string.finished));
        btnMorph.morph(square);
    }

    private void morphToSuccess(final MorphingButton btnMorph)
    {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(R.integer.mb_animation)
                .cornerRadius(R.dimen.mb_height_56)
                .color(R.color.mb_green)
                .colorPressed(R.color.mb_green_dark)
                .icon(R.drawable.ic_done)
                .text("Success");
        btnMorph.morph(circle);
    }

    private void morphToFailure(final MorphingButton btnMorph, int duration)
    {
        MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(R.dimen.mb_height_56)
                .color(R.color.mb_blue)
                .colorPressed(R.color.mb_blue_dark)
                .icon(R.drawable.ic_lock);
        btnMorph.morph(circle);
    }
}
