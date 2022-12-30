package com.icia.livedata;

import static com.icia.livedata.RemoteService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;

import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;
import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<User> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiClient.getUsersList().observe(this, new Observer<Resource<UserResponse>>() {
            @Override
            public void onChanged(Resource<UserResponse> response) {
                if (response.isSuccess()) {
                    System.out.println("MainActivity - onChanged : " + response.toString());
                    data = (List<User>) response.getResource();
                    Log.i(TAG, "onChanged: ${data.data[0]}");
                } else {
                    response.getError().printStackTrace();
                }
            }
        });

        Call call = ApiClient.getSingleUser(1);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}