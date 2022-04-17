package com.example.nasa.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NasamainresponseItem")
data class itemsdb (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var date: String,
    var explanation: String,
    var hdurl: String,
    var media_type: String,
    var service_version: String,
    var title: String,
    var url: String
)