package com.mindorks.bootcamp.learndagger;

import android.app.Application;
import android.util.Log;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.components.ApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.components.DaggerApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.modules.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;

    public ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component =  DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        component.inject(this);

        Log.d("DEBUG" , networkService.toString());
    }
}