package com.ucb.data

import com.ucb.domain.Movie

interface IServerDataSource {
    suspend fun getMovies(): List<Movie>
}