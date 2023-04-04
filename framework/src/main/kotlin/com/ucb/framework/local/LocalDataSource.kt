package com.ucb.framework.local

import com.ucb.data.ILocalDataSource
import com.ucb.domain.Movie

class LocalDataSource : ILocalDataSource {
    override fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}