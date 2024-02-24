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

public class RegisterActivity extends AppCompatActivity
{
    FirebaseAuth mAuth;
    EditText emailET;
    EditText passwordET;
    Button registerBtn;
    TextView goToLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mAuth = FirebaseAuth.getInstance();
        emailET = findViewById(R.id.et_email);
        passwordET = findViewById(R.id.et_password);
        registerBtn = findViewById(R.id.btn_register);
        goToLoginActivity = findViewById(R.id.tv_gotologinsite);

        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();

                if (email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                }
                else if (password.length() < 8)
                {
                    Toast.makeText(getApplicationContext(), "Hasło musi zawierać min. 8 znaków", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.i("LENZGTH", String.valueOf(password.length()));
                    Log.i("LOG", email);
                    Log.i("PASS", password);
                    register(email, password);
                }
            }
        });

        goToLoginActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }

    public void register(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    if (task.isSuccessful())
                    {
                        Log.i("REGISTER", "COMPLETE");
                        Toast.makeText(getApplicationContext(), "Zarejestrowano pomyślnie!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                    else
                    {
                        Log.e("REGISTER", Objects.requireNonNull(task.getException()).toString());
                        Toast.makeText(getApplicationContext(), "Wystąpił problem podczas rejestracji!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}