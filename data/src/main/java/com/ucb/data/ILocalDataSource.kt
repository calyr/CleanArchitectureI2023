package com.ucb.data

interface ILocalDataSource {
    fun getMovies(): ArrayList<LocalMovie>
}