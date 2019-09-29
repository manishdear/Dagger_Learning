package com.mindorks.bootcamp.learndagger.di.components;

import android.app.Activity;

import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(Activity activity);
}
