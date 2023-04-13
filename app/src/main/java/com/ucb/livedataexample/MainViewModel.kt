package com.ucb.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucb.domain.Movie
import com.ucb.usercases.GetPopularMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val popularMovies: GetPopularMovies): ViewModel() {
    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel() {
        class Content(val movies: List<Movie>) : UiModel()
    }
    fun loadMovies() {
        GlobalScope.launch {
            _model.value = UiModel.Content(popularMovies.invoke())
        }
    }

}