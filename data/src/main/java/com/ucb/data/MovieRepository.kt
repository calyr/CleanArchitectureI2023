package com.ucb.data

import com.ucb.domain.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(val localDataSource: ILocalDataSource, val serverDataSource: IServerDataSource) {

    suspend fun getMovies() : List<Movie> {
        return serverDataSource.getMovies()}
}