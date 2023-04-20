package com.ucb.livedataexample.di

import com.ucb.data.MovieRepository
import com.ucb.usercases.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPopularMoviesUseCase(
        movieRepository: MovieRepository
    )   = GetPopularMovies(movieRepository)
}