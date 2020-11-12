package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllTrendingMovies(): LiveData<List<TrendingMovieResults>> =
        mMovieDao.getAllTrendingMovies()

    fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMovieResults>> =
        mMovieDao.getBookmarkedTrendingMovies()

    fun setMovieBookmark(movie: TrendingMovieResults?, newState: Boolean) {
        if (movie != null) {
            movie.bookmarked = newState
            mMovieDao.updateTrendingMovie(movie)
        }
    }

    fun insertTrendingMovies(movies: List<TrendingMovieResults>) =
        mMovieDao.insertTrendingMovie(movies)
}