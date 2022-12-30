package com.icia.livedata;

import androidx.lifecycle.LiveData;

import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface ApiInterface {
    @GET("users")
    LiveData<Resource<UserResponse>> getUsers();

    @GET("users/{user_id}")
    Call<UserResponse> getSingleUser(@Path("user_id") int user_id);
}
