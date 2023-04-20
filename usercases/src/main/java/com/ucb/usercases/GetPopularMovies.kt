package com.ucb.usercases

import com.ucb.data.MovieRepository
import com.ucb.domain.Movie
import javax.inject.Inject

class GetPopularMovies @Inject constructor (val repository: MovieRepository) {
    suspend fun invoke() : List<Movie> {
        return repository.getMovies()
    }
}