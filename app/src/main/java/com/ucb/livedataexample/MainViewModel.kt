package com.ucb.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucb.domain.Movie
import com.ucb.usercases.GetPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val popularMovies: GetPopularMovies): ViewModel() {
    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel() {
        class Content(val movies: List<Movie>) : UiModel()
        class Loading(): UiModel()
    }
    fun loadMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            _model.postValue(UiModel.Content(popularMovies.invoke()))
        }
    }

}