package peruapps.movies.ui.movie.di

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import peruapps.movies.databinding.ActivityListMovieBinding
import peruapps.movies.ui.movie.ListMovieViewModel
import peruapps.movies.ui.movie.ListMoviesAdapter
import peruapps.movies.ui.movie.MovieModelMapper

val listMovieModule = module {
    viewModel { ListMovieViewModel(get(), get()) }

    factory<ActivityListMovieBinding> { (activity: Activity, @LayoutRes layout: Int) ->
        DataBindingUtil.setContentView(
            activity,
            layout
        )
    }

    factory { MovieModelMapper() }

    factory { (onClickItemListener: ListMoviesAdapter.OnClickItemListener) ->
        ListMoviesAdapter(
            onClickItemListener
        )
    }
}