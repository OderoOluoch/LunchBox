package com.odero.lunchbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_home);
        logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(HomeActivity.this,LogInActivity.class));
        });
    }
}