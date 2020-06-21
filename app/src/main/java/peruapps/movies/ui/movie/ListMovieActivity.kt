package peruapps.movies.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import peruapps.movies.R
import peruapps.movies.databinding.ActivityListMovieBinding
import peruapps.movies.ui.navigator.Navigator
import peruapps.movies.ui.util.onEndless

class ListMovieActivity : AppCompatActivity(), ListMoviesAdapter.OnClickItemListener {

    private val viewModel: ListMovieViewModel by inject()
    private val binding: ActivityListMovieBinding by inject {
        parametersOf(
            this,
            R.layout.activity_list_movie
        )
    }
    private val navigator: Navigator by inject()

    private val adapter: ListMoviesAdapter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setViewModel()
        setRecycler()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setRecycler() {
        binding.moviesRecycler.onFlingListener = null
        PagerSnapHelper().attachToRecyclerView(binding.moviesRecycler)
        binding.moviesRecycler.adapter = adapter
        binding.moviesRecycler.onEndless {
            viewModel.getMovies()
        }
    }

    private fun setViewModel() {
        viewModel.apply {
            movieLiveData.observe(::getLifecycle, ::observerMovies)
            getMovies()
        }
    }

    private fun observerMovies(movies: MutableList<MovieModel>) {
        Log.e("GET_DATA", "- ${movies.size}")
        adapter.addMovies(movies)
    }

    override fun onClickItem(view: View, movie: MovieModel) {
        navigator.goToDetail(this, view, movie)
    }
}