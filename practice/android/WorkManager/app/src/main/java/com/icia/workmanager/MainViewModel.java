package com.icia.workmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.icia.workmanager.repository.NumberRepository;

public class MainViewModel extends AndroidViewModel {

    private final NumberRepository repository;

    public MutableLiveData<Integer> progressLiveData = new MutableLiveData<>(0);

    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = new NumberRepository(((App) application).mainThreadHandler, ((App) application).executorService);
    }

    public void longTask() {
        repository.longTask(result -> {
            if(result instanceof Result.Success) {
                progressLiveData.postValue(((Result.Success<Integer>) result).data);
            } else if(result instanceof Result.Error) {
                // 에러 처리
            }
        });
    }

}
