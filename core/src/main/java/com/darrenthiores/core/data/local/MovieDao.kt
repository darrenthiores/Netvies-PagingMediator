package com.darrenthiores.core.data.local

import androidx.paging.PagingSource
import androidx.room.*
import com.darrenthiores.core.model.data.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: List<MovieEntity>)

    @Query("SELECT * FROM movieEntity ORDER BY remoteId")
    fun getMovie(): PagingSource<Int, MovieEntity>

    @Query("DELETE FROM movieEntity")
    suspend fun clearAll()

}