package com.ucb.usercases

import com.ucb.data.MovieRepository
import com.ucb.domain.Movie

class GetPopularMovies(val repository: MovieRepository) {
    suspend fun invoke() : List<Movie> {
        return repository.getMovies()
    }
}