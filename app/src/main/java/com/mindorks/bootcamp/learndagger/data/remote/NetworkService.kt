package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.qualifier.NetworkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(context: Context, @NetworkInfo apiKey: String) {

    fun getDummyData(): String = "NETWORK_DUMMY_DATA"
}