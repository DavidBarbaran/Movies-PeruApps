package peruapps.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import peruapps.movies.domain.auth.AuthUseCase
import peruapps.movies.domain.movie.GetMovieUseCase

class ListMovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val movieModelMapper: MovieModelMapper,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _movieLiveData = MutableLiveData<MutableList<MovieModel>>()
    val movieLiveData: LiveData<MutableList<MovieModel>>
        get() = _movieLiveData

    private val _logoutLiveData = MutableLiveData<Any>()
    val logoutLiveData: LiveData<Any>
        get() = _logoutLiveData

    private var page = 0
    private var loading = false

    fun getMovies() {
        if (!loading) {
            loading = true
            viewModelScope.launch(Dispatchers.IO) {
                val movies = getMovieUseCase.getMovies(page)
                page++
                launch(Dispatchers.Main) {
                    _movieLiveData.value = movieModelMapper.parse(movies)
                }
                loading = false
            }
        }
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            authUseCase.logout()
            launch(Dispatchers.Main) {
                _logoutLiveData.value = true
            }
        }
    }
}