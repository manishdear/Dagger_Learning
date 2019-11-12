package com.mindorks.bootcamp.learndagger.ui.main

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.local.entity.Address
import com.mindorks.bootcamp.learndagger.data.local.entity.User
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.ActivityScope
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) {


    companion object{
        const val TAG = "MainViewModel"
    }
    val user = MutableLiveData<User>()

    val users = MutableLiveData<List<User>>()

    var allUser :List<User> = emptyList()

    init {
        compositeDisposable.add(
            databaseService.userDao()
                    .count()
                    .flatMap {
                        if (it == 0)
                            databaseService.userDao()
                                    .insertMany(
                                            User(name = "Test 1",
                                                    address = Address("Delhi", "India")),
                                            User(name = "Test 2",
                                                    address = Address("New Youk", "US")),
                                            User(name = "Test 3",
                                                    address = Address("Berlin", "Germany")),
                                            User(name = "Test 4",
                                                    address = Address("London", "Uk")),
                                            User(name = "Test 5",
                                                    address = Address("Banglore", "India")),
                                            User(name = "Test 6",
                                                    address = Address("Barcelona", "Spain"))
                                    )
                        else
                            Single.just(0)
                    }
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {
                                Log.d(TAG, "user exist in the table: $it")
                            },
                            {
                                Log.d(TAG, it.toString())
                            }
                    )
        )
    }

    fun getAllUsers(){
        compositeDisposable.add(
                databaseService.userDao()
                        .getAllUsers()
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    allUser = it
                                    users.postValue(it)
                                },
                                {
                                    Log.d(TAG,it.toString())
                                }
                        )
        )
    }

    fun deleteUser(){
        if(allUser.isNotEmpty())
            compositeDisposable.add(
                    databaseService.userDao()
                            .delete(allUser[0])
                            .flatMap {
                                databaseService.userDao()
                                        .getAllUsers()
                            }
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    {
                                        allUser = it
                                        users.postValue(it)
                                    },
                                    {
                                        Log.d(TAG,it.toString())
                                    }
                            )
            )
    }

    fun onDestroy(){
        compositeDisposable.dispose()
    }
}
