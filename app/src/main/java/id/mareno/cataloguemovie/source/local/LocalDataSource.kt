package id.mareno.cataloguemovie.source.local

import android.util.Log
import androidx.lifecycle.LiveData
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        mMovieDao.getAllTrendingMovies()

    fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        mMovieDao.getBookmarkedTrendingMovies()

    fun setTrendingMovieBookmark(movie: TrendingMoviesEntity?, newState: Boolean) {
        if (movie != null) {
            movie.bookmarked = newState
            mMovieDao.updateTrendingMovie(movie)
            Log.d("BOOKMARKED_MOVIE", movie.title + newState.toString())
        }
    }

    fun insertTrendingMovies(movies: List<TrendingMoviesEntity>) =
        mMovieDao.insertTrendingMovie(movies)
}