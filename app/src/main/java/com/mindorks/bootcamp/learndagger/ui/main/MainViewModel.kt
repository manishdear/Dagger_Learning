package com.mindorks.bootcamp.learndagger.ui.main

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService

class MainViewModel(private val databaseService: DatabaseService, private val networkService: NetworkService) {

    fun getSomeData() : String{
        return " ${databaseService.dummyData} :  ${networkService.dummyData}"
    }
}