package com.ucb.framework.server

import com.google.gson.annotations.SerializedName

data class ServerResponse(
    val page: Int,
    @SerializedName("results") val results: List<ServerMovie>
)