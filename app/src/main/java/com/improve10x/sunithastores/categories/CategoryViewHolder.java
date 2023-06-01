package com.improve10x.sunithastores.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sunithastores.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoryItemBinding binding;

    public CategoryViewHolder(@NonNull CategoryItemBinding categoryItemBinding) {
        super(categoryItemBinding.getRoot());
        binding = categoryItemBinding;
    }
}
