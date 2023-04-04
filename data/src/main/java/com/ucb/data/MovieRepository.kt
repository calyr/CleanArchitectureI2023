package com.ucb.data

import com.ucb.domain.Movie

class MovieRepository(val localDataSource: ILocalDataSource, val serverDataSource: IServerDataSource) {

    fun getMovies() : List<Movie> {
        return localDataSource.getMovies().map { it.toDomainMovie() }
    }
}