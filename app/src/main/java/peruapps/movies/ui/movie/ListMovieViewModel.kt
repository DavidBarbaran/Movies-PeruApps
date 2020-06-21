package peruapps.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import peruapps.movies.domain.movie.GetMovieUseCase

class ListMovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val movieModelMapper: MovieModelMapper
) : ViewModel() {

    private val _movieLiveData = MutableLiveData<MutableList<MovieModel>>()

    val movieLiveData: LiveData<MutableList<MovieModel>>
        get() = _movieLiveData

    var page = 0

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMovieUseCase.getMovies(page)
            page++
            launch(Dispatchers.Main) {
                _movieLiveData.value = movieModelMapper.parse(movies)
            }
        }
    }
}