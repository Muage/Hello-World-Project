package com.icia.livedata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    private Long page;
    private Long total;
    private List<User> data;

    @SerializedName("per_page")
    private Long prePage;

    @SerializedName("total_pages")
    private Long totalPages;

}
