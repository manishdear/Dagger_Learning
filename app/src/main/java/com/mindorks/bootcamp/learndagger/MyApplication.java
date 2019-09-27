package com.mindorks.bootcamp.learndagger;

import android.app.Application;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.DependencyComponent;

public class MyApplication extends Application {

    public NetworkService networkService;
    public DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        DependencyComponent.inject(this);
    }
}