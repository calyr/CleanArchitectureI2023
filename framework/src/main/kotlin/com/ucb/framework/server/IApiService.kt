package com.ucb.framework.server

import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("discover/movie?short_by=popularity.desc")
    suspend fun listPopularMovies(@Query("api_key") apiKey: String) : ServerResponse
}
