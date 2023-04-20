package com.ucb.livedataexample.server

import com.google.gson.annotations.SerializedName

data class ServerMovie(@SerializedName("poster_path") val image_path: String, @SerializedName("overview") val description: String, @SerializedName("original_title") val title: String)