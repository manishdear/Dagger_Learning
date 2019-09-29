package com.mindorks.bootcamp.learndagger;

import android.app.Application;
import android.util.Log;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.components.DaggerApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build()
                .inject(this);

        Log.d("DEBUG" , networkService.toString());
    }
}