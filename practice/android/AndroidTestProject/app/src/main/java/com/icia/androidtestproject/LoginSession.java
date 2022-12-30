package com.icia.androidtestproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginSession {

    static final String loginUser = "username";
    static final String Usercode = "u_code";

    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    // 정보 저장
    public static void setUserName(Context context, String username) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(loginUser, username);
        editor.commit();
    }

    // 정보 읽기
    public static String getUserName(Context context) {
        return getSharedPreferences(context).getString(loginUser, "");
    }

    // 로그아웃
    public static void clearUserName(Context context) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.commit();
    }

    // u_code
    public static void setU_code(Context context, String u_code) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(Usercode, u_code);
        editor.commit();
    }

    public static String getU_code(Context context) {
        return getSharedPreferences(context).getString(Usercode, "");
    }

}
