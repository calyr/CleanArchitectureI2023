package com.ucb.data

interface IServerDataSource {
    fun getMovies(): ArrayList<ServerMovie>
}