package com.odero.lunchbox;

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

public class SignUpActivity extends AppCompatActivity {

    EditText emailView, passwordView;
    TextView loginInstead;
    Button register;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailView = findViewById(R.id.emailInputRegisterView);
        passwordView = findViewById(R.id.passwordInputRegisterView);
        loginInstead = findViewById(R.id.logInInstead);
        register = findViewById(R.id.registerButton);

        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(view -> {
            registerUser();
        });

        loginInstead.setOnClickListener(view ->{
            startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
        });
    }

    private void registerUser(){
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if(TextUtils.isEmpty(email)){
            emailView.setError("Email field can not be Empty");
            emailView.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            passwordView.setError("Password field can not be Empty");
            passwordView.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull  Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
                    }else {
                        Toast.makeText(SignUpActivity.this,"Registration error: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}