package com.mindorks.bootcamp.learndagger.ui.home

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService
import com.mindorks.bootcamp.learndagger.di.FragmentScope
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper

@FragmentScope
class HomeViewModel(var databaseService: DatabaseService, var networkService: NetworkService, var networkHelper: NetworkHelper) {

    fun getSomeData() : String = " ${databaseService.getDummyData()}  : ${networkService.getDummyData()} : ${networkHelper}"


}