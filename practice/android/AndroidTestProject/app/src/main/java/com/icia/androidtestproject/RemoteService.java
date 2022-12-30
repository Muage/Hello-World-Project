package com.icia.androidtestproject;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    public final String BASE_URL = "http://192.168.0.194:8088/";

    // 일반 회원가입
    @POST("/api/user/and_insert")
    Call<Integer> and_insert(@Body UserVO userVO);

    // 카카오 회원가입
    @POST("/api/user/and_kakao_insert")
    Call<Integer> and_kakao_insert(@Body UserVO userVO);

    // 일반 로그인
    @POST("api/user/and_login")
    Call <UserVO> and_login(@Body UserVO userVO);

    // 문자인증
    @GET("api/user/sendAuthSMS")
    Call<String> sendAuthSMS(@Query("phoneNumber") String phoneNumber);

}
