package com.example.movieapi1.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi1.Network.model.Model
import com.example.movieapi1.R

class Adapter: RecyclerView.Adapter<Holder>() {

    var model = mutableListOf<Model>()

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(model[position])
    }

    fun setData(items: MutableList<Model>) {
        model = items
        notifyDataSetChanged()
    }
}