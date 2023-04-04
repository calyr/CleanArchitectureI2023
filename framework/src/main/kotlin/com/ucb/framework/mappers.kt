package com.ucb.data

import com.ucb.domain.Movie
import com.ucb.framework.local.LocalMovie
import com.ucb.framework.server.ServerMovie


fun LocalMovie.toDomainMovie() : Movie = Movie(path, title)

fun ServerMovie.toDomainMovie(): Movie = Movie(image_path,title)