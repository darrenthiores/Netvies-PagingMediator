package com.darrenthiores.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darrenthiores.core.model.data.entity.MovieRemoteKeys
import com.darrenthiores.core.model.data.entity.MovieEntity

@Database(entities = [MovieEntity::class, MovieRemoteKeys::class], version = 1)
abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun movieRemoteKeysDao(): MovieRemoteKeysDao

}