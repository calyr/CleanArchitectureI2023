package com.ucb.framework.server

import com.ucb.data.IServerDataSource
import com.ucb.data.toDomainMovie
import com.ucb.domain.Movie

class ServerDataSource(val apiRest: RetrofitBuilder, val apiKey: String) : IServerDataSource {
    override suspend fun getMovies(): List<Movie> {
        val response = apiRest.apiService.listPopularMovies(apiKey)
        return response.results.map { it.toDomainMovie() }
    }
}