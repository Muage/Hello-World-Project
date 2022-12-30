package com.icia.livedata;

import androidx.lifecycle.LiveData;

import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ApiClient {
    static LiveData<Resource<UserResponse>> getUsersList() {
        return RetrofitClient.getClient().create(ApiInterface.class).getUsers();
    }

    static Call<UserResponse> getSingleUser(int user_id) {
        return RetrofitClient.getClient().create(ApiInterface.class).getSingleUser(user_id);
    }
}
