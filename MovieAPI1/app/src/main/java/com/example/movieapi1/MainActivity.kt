package com.example.movieapi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapi1.Network.Info
import com.example.movieapi1.Network.MovieInfoOpenApiService
import com.example.movieapi1.Network.MovieListRepository
import com.example.movieapi1.Network.model.Model
import com.example.movieapi1.Network.model.Results
import com.example.movieapi1.RecyclerView.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback

/*
MovieInfoOpenApiService Interface 이해 안 됨
MovieListRepository 이해 안 됨
MainActivity 이해 안 됨
 */

class MainActivity : AppCompatActivity() {

    lateinit var adapter: Adapter
    lateinit var repository: MovieListRepository
    lateinit var apiInterface: MovieInfoOpenApiService
    lateinit var dateSet: String

//    var adapter: Adapter? = null
//    var repository: MovieListRepository? = null
//    var apiInterface: MovieInfoOpenApiService? = null
//    var dateSet: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateInit()

        adapter = Adapter()
        repository = MovieListRepository()

        apiInterface = repository.initBuild()!!

        rvContainer.layoutManager = LinearLayoutManager(this)
        rvContainer.adapter = adapter

        boxOfficeSearch() // ******************------------------------------------ 함수 안 타고 여기서 바로 앱 중단됨 (이 함수 내부의 로직이 뭔가 문제가 있음) -> 로그에 인터넷 권한 문제가 찍혔다.

    }

    private fun dateInit() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val mNow = System.currentTimeMillis()
        val mDate = Date(mNow)
        dateFormat.format(mDate)
        dateSet = dateFormat(dateFormat.calendar.get(Calendar.YEAR), dateFormat.calendar.get(
            Calendar.MONTH) + 1 , dateFormat.calendar.get(Calendar.DAY_OF_MONTH) -1)
    }

    private fun dateFormat(year: Int, month: Int, day: Int) : String {
        var result =
            if (month <= 9 && day <= 9) year.toString() + "0" + month + "0" + day
            else if (day <= 9) year.toString() + month + "0" + day
            else if (month <= 9) year.toString() + "0" + month + day
            else year.toString() + month + day
        return result
    }

    private fun boxOfficeSearch() {
        apiInterface.getBoxOffice(Info.KEY, dateSet).enqueue(object : Callback, retrofit2.Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val body = response.body()

                Log.d("body : ", "=====================================================" + body.toString() )

                val list : MutableList<Model>? = body?.boxOfficeResult?.dailyBoxOfficeList
                if(list != null) adapter.setData(list)
            }
            override fun onFailure(call: Call<Results>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}