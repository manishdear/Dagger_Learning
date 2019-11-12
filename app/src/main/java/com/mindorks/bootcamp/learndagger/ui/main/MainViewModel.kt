package com.mindorks.bootcamp.learndagger.ui.main

import android.location.Address
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.local.entity.User
import com.mindorks.bootcamp.learndagger.data.local.entity.UserAddress
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.ActivityScope
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
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

    val addresses = MutableLiveData<List<UserAddress>>()

    var allUser :List<User> = emptyList()

    var allAddress :List<UserAddress> = emptyList()

    init {
        compositeDisposable.add(
            databaseService.userDao()
                    .count()
                    .flatMap {
                        if (it == 0)
                            databaseService.addressDao()
                                    .insertMany(
                                            UserAddress(city = "Delhi", country =  "India"),
                                            UserAddress(city = "New Youk", country = "US"),
                                            UserAddress(city = "Berlin", country = "Germany"),
                                            UserAddress(city = "London", country = "Uk"),
                                            UserAddress(city = "Banglore", country = "India"),
                                            UserAddress(city = "Barcelona",country =  "Spain")
                                    )
                                    .flatMap {addressIds ->
                                        databaseService.userDao()
                                                .insertMany(
                                                        User(name = "Test 1",
                                                                addressId = addressIds[0]),
                                                        User(name = "Test 2",
                                                                addressId = addressIds[1]),
                                                        User(name = "Test 3",
                                                                addressId = addressIds[2]),
                                                        User(name = "Test 4",
                                                                addressId = addressIds[3]),
                                                        User(name = "Test 5",
                                                                addressId = addressIds[4]),
                                                        User(name = "Test 6",
                                                                addressId = addressIds[5])
                                                )
                                    }
                        else Single.just(0)
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

    fun getAllAddresses(){
        compositeDisposable.add(
                databaseService.addressDao()
                        .getAllAddresses()
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    allAddress = it
                                    addresses.postValue(it)
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

    fun deleteAddress(){
        if(allUser.isNotEmpty())
            compositeDisposable.add(
                    databaseService.addressDao()
                            .delete(allAddress[0])
                            .flatMap {
                                databaseService.addressDao()
                                        .getAllAddresses()
                            }
                            .subscribeOn(Schedulers.io())
                            .subscribe(
                                    {
                                        allAddress = it
                                        addresses.postValue(it)
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
