package com.ucb.livedataexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ucb.domain.Movie

class MainAdapter(val list: List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_row, parent, false)
        return MainViewHolder(view)
    }
    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = list.get(position)

        holder.itemView.findViewById<TextView>(R.id.movie_title).text = movie.title
    }
}

