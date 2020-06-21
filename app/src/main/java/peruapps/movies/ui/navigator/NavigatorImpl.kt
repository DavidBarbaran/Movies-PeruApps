package peruapps.movies.ui.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import peruapps.movies.R
import peruapps.movies.ui.auth.AuthActivity
import peruapps.movies.ui.detail.DetailMovieActivity
import peruapps.movies.ui.movie.ListMovieActivity
import peruapps.movies.ui.movie.MovieModel

class NavigatorImpl(private val context: Context) : Navigator {

    override fun goToAuth() {
        context.startActivity(Intent(context, AuthActivity::class.java))
    }

    override fun goToList() {
        context.startActivity(Intent(context, ListMovieActivity::class.java))
    }

    override fun goToDetail(activity: Activity, view: View, movie: MovieModel) {
        val intent = DetailMovieActivity.getCallingIntent(context, movie)
        val options =
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                view,
                context.getString(R.string.movie_transition)
            )
        activity.startActivity(intent, options.toBundle())
    }
}