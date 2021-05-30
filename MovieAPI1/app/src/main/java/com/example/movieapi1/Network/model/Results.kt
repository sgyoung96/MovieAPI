package com.example.movieapi1.Network.model

import com.example.movieapi1.Network.model.BoxOfficeResult
import java.io.Serializable

data class Results(
    var boxOfficeResult: BoxOfficeResult
): Serializable
