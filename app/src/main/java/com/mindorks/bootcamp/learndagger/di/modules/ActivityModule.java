package com.mindorks.bootcamp.learndagger.di.modules;

import android.app.Activity;
import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.qualifier.ActivityContext;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityContext
    @Provides
    Context provideContext(){
        return activity;
    }

}
