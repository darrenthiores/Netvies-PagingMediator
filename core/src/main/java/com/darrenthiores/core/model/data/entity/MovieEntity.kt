package com.darrenthiores.core.model.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntity")
data class MovieEntity(

    @PrimaryKey(autoGenerate = true)
    var remoteId: Int = 0,
    val id: Int,
    val title: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double

)
