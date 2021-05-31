package com.example.movieapi2.Network.Model

data class BoxOfficeResult(
    var boxofficeType: String,                  //박스오피스 종류를 출력합니다.
    var showRange: String,                      //박스오피스 조회 일자를 출력합니다.
    var dailyBoxOfficeList: DailyBoxOfficeList
)