package com.ucb.livedataexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.ucb.data.MovieRepository
import com.ucb.domain.Movie
import com.ucb.framework.local.LocalDataSource
import com.ucb.framework.server.RetrofitBuilder
import com.ucb.framework.server.ServerDataSource
import com.ucb.usercases.GetPopularMovies

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var counter: Int = 0
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        mainViewModel = MainViewModel(GetPopularMovies(MovieRepository(LocalDataSource(), ServerDataSource( RetrofitBuilder , getString(R.string.api_key)))))

        mainViewModel.model.observe(this, Observer(::updateUi))

        mainViewModel.loadMovies()
    }

    private fun updateUi(uiModel: MainViewModel.UiModel?) {

        when( uiModel) {
            is MainViewModel.UiModel.Content -> showList(uiModel.movies)
            else -> Toast.makeText(this, "AS", Toast.LENGTH_SHORT).show()
        }

    }

    fun showList(list: List<Movie>) {
        recyclerView.adapter = MainAdapter(list)
    }
}