package com.ucb.livedataexample.di

import android.app.Application
import com.ucb.data.IServerDataSource
import com.ucb.livedataexample.server.IApiService
import com.ucb.livedataexample.server.RetrofitBuilder
import com.ucb.livedataexample.server.ServerDataSource
import com.ucb.livedataexample.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @ApiKey
    fun provideApiKey(app: Application): String = app.getString(R.string.api_key)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): IApiService {
        return retrofit.create(IApiService::class.java)
    }

    @Provides
    fun provideRemoteDataSource(apiRest: RetrofitBuilder, @ApiKey apiKey: String) : IServerDataSource = ServerDataSource(apiRest,apiKey)
}
