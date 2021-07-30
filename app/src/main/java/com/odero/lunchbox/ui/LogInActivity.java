package com.odero.lunchbox.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.odero.lunchbox.R;

public class LogInActivity extends AppCompatActivity {
    EditText passwordView,emailView;
    Button loginButton;
    TextView registerInstead;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();

        passwordView = findViewById(R.id.passwordInputLoginView);
        emailView = findViewById(R.id.emailInputLoginView);
        loginButton = findViewById(R.id.loginButton);
        registerInstead = findViewById(R.id.registerInstead);

        loginButton.setOnClickListener(view ->{
            loginUser();
        });
        registerInstead.setOnClickListener(view ->{
            startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
        });
    }
    private void loginUser(){
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if(TextUtils.isEmpty(email)){
            emailView.setError("Email field can not be Empty");
            emailView.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            passwordView.setError("Password field can not be Empty");
            passwordView.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LogInActivity.this,"Authentication successful",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                    }else {
                        Toast.makeText(LogInActivity.this,"Authentication error: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }
}