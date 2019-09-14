package com.example.android.zimad_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android.zimad_test.data.KotApiRepository;
import java.util.Arrays;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KotApiRepository kotApiRepository = KotApiRepository.getInstance();



        kotApiRepository.getCatPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                    Log.d("TestPish", "" + Arrays.toString(response.getData().toArray()));
                }, throwable -> {
                    Log.d("TestPish", "error " +throwable.getMessage());
                });
    }
}
