package com.ucb.livedataexample.di

import com.ucb.data.MovieRepository
import com.ucb.livedataexample.local.LocalDataSource
import com.ucb.livedataexample.server.ServerDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideMovieRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: ServerDataSource
    ) = MovieRepository(localDataSource, remoteDataSource)
}