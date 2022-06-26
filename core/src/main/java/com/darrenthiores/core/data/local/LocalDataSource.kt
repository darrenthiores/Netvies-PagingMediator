package com.darrenthiores.core.data.local

import androidx.paging.PagingSource
import com.darrenthiores.core.model.data.entity.MovieRemoteKeys
import com.darrenthiores.core.model.data.entity.MovieEntity

class LocalDataSource(val movieDb: MovieDb) {

    private val movieDao = movieDb.movieDao()
    private val movieRemoteKeysDao = movieDb.movieRemoteKeysDao()

    suspend fun insert(movie: List<MovieEntity>) {
        movieDao.insert(movie)
    }

    fun getMovie(): PagingSource<Int, MovieEntity> = movieDao.getMovie()

    suspend fun clearAll() = movieDao.clearAll()

    suspend fun getRemoteKeys(id: Int): MovieRemoteKeys = movieRemoteKeysDao.getRemoteKeys(id)

    suspend fun addAllRemoteKeys(remoteKeys: List<MovieRemoteKeys>) = movieRemoteKeysDao.addAllRemoteKeys(remoteKeys)

    suspend fun deleteAllRemoteKeys() = movieRemoteKeysDao.deleteAllRemoteKeys()

}