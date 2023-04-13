package com.ucb.framework.server

import com.ucb.data.IServerDataSource
import com.ucb.data.toDomainMovie
import com.ucb.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ServerDataSource(val apiRest: RetrofitBuilder, val apiKey: String) : IServerDataSource {
    override suspend fun getMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiRest.apiService.listPopularMovies(apiKey)
            response.results.map { it.toDomainMovie() }
        }
    }
}