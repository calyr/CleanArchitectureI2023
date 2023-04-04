package com.ucb.data

import com.ucb.domain.Movie

class MovieRepository(val localDataSource: ILocalDataSource, val serverDataSource: IServerDataSource) {

    suspend fun getMovies() : List<Movie> {
        return serverDataSource.getMovies()}
}