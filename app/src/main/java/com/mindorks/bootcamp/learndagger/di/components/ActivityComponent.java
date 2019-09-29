package com.mindorks.bootcamp.learndagger.di.components;

import android.app.Activity;

import com.mindorks.bootcamp.learndagger.di.modules.ActivityModule;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);
}
