package com.mindorks.bootcamp.learndagger.di.Component;


import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.di.Module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component ( modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);
}
