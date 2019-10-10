package com.mindorks.bootcamp.learndagger.utils

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(@ApplicationContext var context: Context) {

    fun isNetworkConnected(): Boolean{
        return true
    }
}