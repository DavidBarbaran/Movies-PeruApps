package peruapps.movies.domain.movie

import peruapps.movies.domain.session.SessionRepository

class GetMovieInteractor(
    private val sessionRepository: SessionRepository,
    private val movieRepository: MovieRepository
) : GetMovieUseCase {

    override suspend fun getMovies(page: Int): MutableList<Movie> {
        val token = sessionRepository.getToken()
        return movieRepository.getMovies(token, page)
    }
}