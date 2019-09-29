package com.mindorks.bootcamp.learndagger.di.Module;

import android.app.Activity;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;
import com.mindorks.bootcamp.learndagger.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private MainActivity activity;

    public ActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    MainViewModel provideMainViewModel(){
        return new MainViewModel(new DatabaseService(activity.getApplication(), "abc", 1),
                new NetworkService(activity.getApplication(), "xyz"));
    }

}
