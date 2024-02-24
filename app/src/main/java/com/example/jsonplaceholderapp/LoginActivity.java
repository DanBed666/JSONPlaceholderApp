package com.example.jsonplaceholderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.Objects;

public class LoginActivity extends AppCompatActivity
{
    FirebaseAuth mAuth;
    EditText emailET;
    EditText passwordET;
    Button loginBtn;
    TextView goToRegisterActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.et_email);
        passwordET = findViewById(R.id.et_password);
        loginBtn = findViewById(R.id.btn_login);
        goToRegisterActivity = findViewById(R.id.tv_gotoregsite);

        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                signIn(emailET.getText().toString(), passwordET.getText().toString());
            }
        });

        goToRegisterActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    public void signIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Log.i("LOGIN", "COMPLETE");
                    Toast.makeText(getApplicationContext(), "Zalogowano pomyślnie!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomepageActivity.class));
                    finish();
                }
                else
                {
                    Log.i("LOG", email);
                    Log.i("PASS", password);
                    Log.e("LOGIN", Objects.requireNonNull(task.getException()).toString());
                    Toast.makeText(getApplicationContext(), "Wystąpił problem podczas logowania!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}