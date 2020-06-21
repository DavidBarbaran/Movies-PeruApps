package peruapps.movies.ui.navigator

import android.content.Context
import android.content.Intent
import peruapps.movies.ui.auth.AuthActivity
import peruapps.movies.ui.movie.ListMovieActivity

class NavigatorImpl(private val context: Context) : Navigator {

    override fun goToAuth() {
        context.startActivity(Intent(context, AuthActivity::class.java))
    }

    override fun goToList() {
        context.startActivity(Intent(context, ListMovieActivity::class.java))
    }

    override fun goToDetail() {
        TODO("Not yet implemented")
    }
}