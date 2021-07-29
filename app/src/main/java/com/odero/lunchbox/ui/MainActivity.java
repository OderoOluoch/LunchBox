package com.odero.lunchbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.odero.lunchbox.R;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextView logoText,brand;
    RelativeLayout loaderLayout;
    Animation loaderTextAnimation, layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        loaderTextAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_to_top);
        logoText = findViewById(R.id.logoText);
        brand = findViewById(R.id.Odero);
        loaderLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderLayout.setVisibility(View.VISIBLE);
                loaderLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logoText.setVisibility(View.VISIBLE);
                        brand.setVisibility(View.VISIBLE);
                        logoText.setAnimation(loaderTextAnimation);
                    }
                },1000);
            }
        },900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser user = mAuth.getCurrentUser();
                if(user == null){
                    startActivity(new Intent(MainActivity.this, LogInActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }


            }
        },8000);

    }
}