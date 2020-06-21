package peruapps.movies.ui.movie

import peruapps.movies.domain.movie.Movie

class MovieModelMapper {

    fun parse(list: MutableList<Movie>): MutableList<MovieModel> {
        val parseList = mutableListOf<MovieModel>()
        list.forEach {
            val detail = MovieDetailModel(it.detail.title, it.detail.description, it.detail.image)
            val movie = MovieModel(it.id, detail)
            parseList.add(movie)
        }
        return parseList
    }
}