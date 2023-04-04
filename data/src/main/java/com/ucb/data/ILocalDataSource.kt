package com.ucb.data

import com.ucb.domain.Movie

interface ILocalDataSource {
    fun getMovies(): List<Movie>
}