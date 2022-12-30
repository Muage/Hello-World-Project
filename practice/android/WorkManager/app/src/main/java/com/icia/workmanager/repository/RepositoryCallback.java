package com.icia.workmanager.repository;

import com.icia.workmanager.Result;

public interface RepositoryCallback<T> {
    void onComplete(Result<T> result);
}