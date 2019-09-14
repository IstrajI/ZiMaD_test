package com.example.android.zimad_test;

import android.app.Application;

import com.example.android.zimad_test.di.ApplicationComponent;
import com.example.android.zimad_test.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.create();
    }
}
