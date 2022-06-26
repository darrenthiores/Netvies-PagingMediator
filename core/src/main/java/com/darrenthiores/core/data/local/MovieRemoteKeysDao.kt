package com.darrenthiores.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darrenthiores.core.model.data.entity.MovieRemoteKeys

@Dao
interface MovieRemoteKeysDao {
    @Query("SELECT * FROM movieremotekeys WHERE id =:id")
    suspend fun getRemoteKeys(id: Int): MovieRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<MovieRemoteKeys>)

    @Query("DELETE FROM movieremotekeys")
    suspend fun deleteAllRemoteKeys()
}