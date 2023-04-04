package com.ucb.data

import com.ucb.domain.Movie


fun LocalMovie.toDomainMovie() : Movie = Movie(path, title)