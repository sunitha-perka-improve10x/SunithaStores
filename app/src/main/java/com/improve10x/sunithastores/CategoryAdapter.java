package com.improve10x.sunithastores;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sunithastores.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    List<String> categories;

    void setData(List<String> categoryList) {
        this.categories = categoryList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding categoryItemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(categoryItemBinding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
       holder.binding.titleTxt.setText(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
