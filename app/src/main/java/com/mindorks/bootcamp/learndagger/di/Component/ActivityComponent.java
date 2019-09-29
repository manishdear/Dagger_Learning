package com.mindorks.bootcamp.learndagger.di.Component;


import com.mindorks.bootcamp.learndagger.di.Module.ActivityModule;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;

import dagger.Component;

@Component( modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);
}
