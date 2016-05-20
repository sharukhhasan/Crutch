package com.sharukhhasan.studycrutch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sharukhhasan.studycrutch.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisterActivity extends AppCompatActivity {
    @InjectView(R.id.input_name) EditText usernameInput;
    @InjectView(R.id.input_email) EditText emailInput;
    @InjectView(R.id.input_password) EditText passwordInput;
    @InjectView(R.id.input_confirmPassword) EditText confirmPasswordInput;
    @InjectView(R.id.btn_signup) Button signUpButton;
    @InjectView(R.id.link_login) TextView loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.inject(this);
    }
}
