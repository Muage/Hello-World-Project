package com.icia.livedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Response;

public abstract class ApiResponse {
    public ApiResponse create(Response response) {
        return if(response.isSuccessful()) {
            Object body = response.body();
            if(body == null || response.code() == 204) {
                ApiEmptyResponse();
            }
        }
    }

    protected abstract void ApiEmptyResponse();
}