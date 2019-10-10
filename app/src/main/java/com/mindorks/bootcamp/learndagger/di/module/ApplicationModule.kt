package com.mindorks.bootcamp.learndagger.di.module

import android.content.Context
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.di.ApplicationContext
import com.mindorks.bootcamp.learndagger.di.DatabaseInfo
import com.mindorks.bootcamp.learndagger.di.NetworkInfo
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule (var application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @DatabaseInfo
    @Provides
    fun provideDatabaseName(): String = "abc"


    @DatabaseInfo
    @Provides
    fun provideDatabaseVersion(): Int = 1

    @NetworkInfo
    @Provides
    fun provideApiKey():String ="SOME_API_KEY"


}