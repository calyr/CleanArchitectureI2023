package com.ucb.livedataexample.local

import com.ucb.data.ILocalDataSource
import com.ucb.domain.Movie
import javax.inject.Inject

class LocalDataSource @Inject constructor() : ILocalDataSource {
    override fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}