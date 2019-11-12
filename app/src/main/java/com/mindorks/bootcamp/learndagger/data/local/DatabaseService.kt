package com.mindorks.bootcamp.learndagger.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mindorks.bootcamp.learndagger.data.local.dao.AddressDao
import com.mindorks.bootcamp.learndagger.data.local.dao.UserDao
import com.mindorks.bootcamp.learndagger.data.local.entity.User
import com.mindorks.bootcamp.learndagger.data.local.entity.UserAddress


@Database(
        entities = [
        User::class,
        UserAddress::class
        ],
        version = 1,
        exportSchema = false
)
abstract class DatabaseService : RoomDatabase(){

    abstract fun userDao(): UserDao

    abstract fun addressDao(): AddressDao
}
