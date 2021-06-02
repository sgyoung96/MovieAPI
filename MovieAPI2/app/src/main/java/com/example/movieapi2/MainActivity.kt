package com.example.movieapi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import com.example.movieapi2.Presenter.Presenter

class MainActivity : AppCompatActivity() {

    lateinit var presenter: Presenter
    lateinit var adapter: Adapter
    lateinit var dataSet: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)
        presenter.setView()

    }
}