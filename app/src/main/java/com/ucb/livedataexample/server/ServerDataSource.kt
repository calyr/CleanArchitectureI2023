package com.ucb.livedataexample.server

import com.ucb.data.IServerDataSource
import com.ucb.data.toDomainMovie
import com.ucb.domain.Movie
import com.ucb.livedataexample.di.ApiKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ServerDataSource @Inject constructor(val apiRest: RetrofitBuilder,@ApiKey val apiKey: String) : IServerDataSource {
    override suspend fun getMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiRest.apiService.listPopularMovies(apiKey)
            response.results.map { it.toDomainMovie() }
        }
    }
}