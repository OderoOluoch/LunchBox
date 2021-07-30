package com.odero.lunchbox.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.odero.lunchbox.R;
import com.odero.lunchbox.adapters.CategoryAdapter;
import com.odero.lunchbox.models.Category;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter categoryAdapter, popularFoodAdapter;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularFoodList;
    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_home);

        displayCategory();

    }

    private void displayCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Pizza","cat_1"));
        categoryList.add(new Category("Burger","cat_2"));
        categoryList.add(new Category("HotDog","cat_3"));
        categoryList.add(new Category("Drinks","cat_4"));
        categoryList.add(new Category("Donuts","cat_4"));

        categoryAdapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(categoryAdapter);
    }
}