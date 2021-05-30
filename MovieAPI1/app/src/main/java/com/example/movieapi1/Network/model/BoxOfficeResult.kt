package com.example.movieapi1.Network.model

data class BoxOfficeResult(
    var boxofficeType: String,
    var showRange: String,
    var dailyBoxOfficeList: MutableList<Model>
)
