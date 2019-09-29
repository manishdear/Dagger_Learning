package com.mindorks.bootcamp.learndagger.di.Module;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication myApplication;

    public ApplicationModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    NetworkService provideNetworkService(){
        return new NetworkService(myApplication, "abc");
    }

    @Singleton
    @Provides
    DatabaseService provideDatabaseService(){
        return new DatabaseService(myApplication, "xyz", 1);
    }
}


















