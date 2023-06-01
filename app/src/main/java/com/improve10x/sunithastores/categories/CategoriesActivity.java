package com.improve10x.sunithastores.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.sunithastores.api.FakeApi;
import com.improve10x.sunithastores.api.FakeApiService;
import com.improve10x.sunithastores.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private ArrayList<String> categoryList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpCategoryAdapter();
        setUpCategoryRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCategories();
    }

    private void fetchCategories() {
        FakeApi fakeApi = new FakeApi();
        FakeApiService fakeApiService = fakeApi.createFakeApiService();
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> categories = response.body();
                categoryAdapter.setData(categories);
                Toast.makeText(CategoriesActivity.this, "Successfully added data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpCategoryRv() {
        binding.categoryRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoryRv.setAdapter(categoryAdapter);
    }

    private void setUpCategoryAdapter() {
        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(categoryList);
    }
}