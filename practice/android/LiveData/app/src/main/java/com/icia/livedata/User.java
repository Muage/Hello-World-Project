package com.icia.livedata;

import com.google.gson.annotations.SerializedName;

public class User {

    private Long id;
    private String email;
    private String avatar;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

}
