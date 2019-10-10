package com.mindorks.bootcamp.learndagger.data.local

import android.content.Context
import com.mindorks.bootcamp.learndagger.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseService @Inject constructor(context: Context, @DatabaseInfo databaseName: String, databaseVersion: Int) {

    fun getDummyData(): String = "DATABASE_DUMMY_DATA"
}