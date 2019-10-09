package com.mindorks.bootcamp.learndagger.di.module;


import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.mindorks.bootcamp.learndagger.di.qualifier.DatabaseInfo;
import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    MyApplication application;

    public ApplicationModule(MyApplication application) {
     this.application = application;
    }


    @ApplicationContext
    @Provides
    Context provideContext(){
        return application;
    }

    @DatabaseInfo
    @Provides
    String provideDatabaseName(){
        return "abc";
    }

    @Provides
    Integer provideDatabaseVersion(){
        return 1;
    }

    @NetworkInfo
    @Provides
    String provideApikey(){
        return "xyz";
    }

//    @Singleton
//    @Provides
//    NetworkService provideNetworkService(){
//        return  new NetworkService(application, "abc ");
//    }
//
//    @Singleton
//    @Provides
//    DatabaseService provideDataBaseService(){
//        return  new DatabaseService(application, "xyz", 1);
//    }
}
