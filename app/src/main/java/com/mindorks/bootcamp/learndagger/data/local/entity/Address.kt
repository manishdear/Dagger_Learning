package com.mindorks.bootcamp.learndagger.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity


data class Address(

        @ColumnInfo(name = "city")
        val city: String,

        @ColumnInfo(name = "country")
        val country: String
) {
}