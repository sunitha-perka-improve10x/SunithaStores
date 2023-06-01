package com.improve10x.sunithastores.api;

import com.improve10x.sunithastores.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeApiService {
    @GET(Constants.CATEGORY_END_POINT)
    Call<List<String>> fetchCategories();


}
