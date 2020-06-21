package peruapps.movies.ui.navigator

import android.app.Activity
import android.view.View
import peruapps.movies.ui.movie.MovieModel

interface Navigator {

    fun goToAuth()

    fun goToList()

    fun goToDetail(activity: Activity, view: View, movie: MovieModel)
}