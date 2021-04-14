package com.example.rmtc.db;

import android.database.Observable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * A liveData extension that lets the observer observe once.
 */
public class LiveDataHelper {

    public static <T> void observeOnce(LiveData<T> liveData, Observer<T> observer) {
        liveData.observeForever(new Observer<T>() {
            @Override
            public void onChanged(T t) {
                liveData.removeObserver(this);
                observer.onChanged(t);
            }
        });
    }
}
