package com.odero.lunchbox.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.odero.lunchbox.R;
import com.odero.lunchbox.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<Category> category;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.category = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view_holder,parent,false);
        return new CategoryViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.categoryName.setText(category.get(position).getCategoryName());
        String imageUrl ="";
        switch (position){
            case 0:{
                imageUrl="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background1));
                break;
            }
            case 1:{
                imageUrl="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background2));
                break;
            }
            case 2:{
                imageUrl="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background3));
                break;
            }
            case 3:{
                imageUrl="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background4));
                break;
            }case 4:{
                imageUrl="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background5));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(imageUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryImage);
    }


    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;

        public CategoryViewHolder(@NonNull  View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryName);
            categoryImage = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
