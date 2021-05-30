package com.example.movieapi1.RecyclerView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi1.Network.model.Model
import com.example.movieapi1.R

class Holder(item: View) : RecyclerView.ViewHolder(item) {

    // 순번
    val tvRNum = item.findViewById<TextView>(R.id.tvRNum)
    // 영화 제목
    val tvMovieNM = item.findViewById<TextView>(R.id.tvMovieNM)
    // 개봉일
    val tvOpenDt = item.findViewById<TextView>(R.id.tvOpenDt)
    // 누적 관광객 수
    val tvAudiAcc = item.findViewById<TextView>(R.id.tvAudiAcc)

    fun bind(model: Model) {
        tvRNum.text = model.rnum
        tvMovieNM.text = model.movieNm
        tvOpenDt.text = model.openDt
        tvAudiAcc.text = model.audiAcc
    }

}