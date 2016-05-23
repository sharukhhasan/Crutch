package com.sharukhhasan.studycrutch.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sharukhhasan.studycrutch.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisterActivity extends AppCompatActivity {
    private final static String TAG = "RegisterActivity";
    @InjectView(R.id.input_name) EditText aliasInput;
    @InjectView(R.id.input_email) EditText emailInput;
    @InjectView(R.id.input_password) EditText passwordInput;
    @InjectView(R.id.input_confirmPassword) EditText confirmPasswordInput;
    @InjectView(R.id.btn_signup) Button signUpButton;
    @InjectView(R.id.link_login) TextView loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);

        mAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //if(!validateRegistration())
                //{
                    createAccount(emailInput.getText().toString(), passwordInput.getText().toString());
                //}
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public boolean validateRegistration()
    {
        String username = aliasInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        boolean incorrect = false;

        if(TextUtils.isEmpty(username))
        {
            aliasInput.setError(getString(R.string.error_username_required));
            incorrect = true;
        }
        if(TextUtils.isEmpty(email))
        {
            emailInput.setError(getString(R.string.error_email_required));
            incorrect = true;
        }
        if(TextUtils.isEmpty(password))
        {
            passwordInput.setError(getString(R.string.error_password_required));
            incorrect = true;
        }
        if(TextUtils.isEmpty(confirmPassword))
        {
            confirmPasswordInput.setError(getString(R.string.error_password_required));
            incorrect = true;
        }
        if(password.length() < 5)
        {
            passwordInput.setError(getString(R.string.error_invalid_password));
            incorrect = true;
        }
        if(!password.equals(confirmPassword))
        {
            confirmPasswordInput.setError(getString(R.string.error_passwords_notequal));
            incorrect = true;
        }

        return incorrect;
    }

    private void createAccount(String email, String password)
    {
        Log.d(TAG, "createAccount:" + email);
        /*if(!validateRegistration())
        {
            return;
        }*/

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                Log.d(TAG, task.getResult().toString());
                if (!task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegisterActivity.this, CourseInputActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
