package com.ucb.data

import com.ucb.domain.Movie
import com.ucb.livedataexample.local.LocalMovie
import com.ucb.livedataexample.server.ServerMovie


fun LocalMovie.toDomainMovie() : Movie = Movie(path, title)

fun ServerMovie.toDomainMovie(): Movie = Movie(image_path,title)