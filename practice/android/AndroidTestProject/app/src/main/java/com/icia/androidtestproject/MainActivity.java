package com.icia.androidtestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    TextView text_u_name;   // 세션에 저장된 u_name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // layout 연결
        text_u_name = findViewById(R.id.text_u_name);

        if(LoginSession.getUserName(MainActivity.this) != "") {  // 세션에 저장된 유저 있으면
            text_u_name.setText(LoginSession.getUserName(MainActivity.this) + "님, 반갑습니다.");
        } else {    // 세션에 저장된 유저 없으면
            text_u_name.setText("로그인 된 유저가 없습니다");
        }
    }

    // 액티비티 이동하기 위한 함수
    public void btnClick(View view) {   // layout에서 onClick 속성 사용
        Intent intent = null;
        switch(view.getId()) {
            case R.id.btn_login:    // LOGIN 버튼 클릭 시
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_logout:    // LOGOUT 버튼 클릭 시
                LoginSession.clearUserName(MainActivity.this);
                Toast.makeText(this, "로그아웃되었습니다", Toast.LENGTH_SHORT).show();
                text_u_name.setText("로그인 된 유저가 없습니다");
                break;

            case R.id.btn_register:    // REGISTER 버튼 클릭 시
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

}