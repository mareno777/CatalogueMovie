package id.mareno.cataloguemovie.source.remote

import androidx.lifecycle.LifecycleOwner
import id.mareno.cataloguemovie.helper.ResponseHelper
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

class RemoteDataSource private constructor(
    private val responseHelper: ResponseHelper,
    private val lifecycleOwner: LifecycleOwner
) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(
            helper: ResponseHelper,
            viewLifecycleOwner: LifecycleOwner
        ): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper, viewLifecycleOwner)
            }
    }

    fun getAllTrendingMovies(callback: LoadTrendingMoviesCallback) {
        responseHelper.loadTrendingMovies()?.observe(lifecycleOwner, { movie ->
            callback.onAllMoviesReceived(movie)
        })
    }

    fun getAllTrendingTvs(callback: LoadTrendingTvsCallback) {
        responseHelper.loadTrendingTvs()?.observe(lifecycleOwner, { movie ->
            callback.onAllMoviesReceived(movie)
        })
    }

    fun getAllPopularMovies(callback: LoadPopularMoviesCallback) {
        responseHelper.loadPopularMovies()?.observe(lifecycleOwner, { movie ->
            callback.onAllMoviesReceived(movie)
        })
    }

    fun getAllPopularTvs(callback: LoadPopularTvsCallback) {
        responseHelper.loadPopularTvs()?.observe(lifecycleOwner, { movie ->
            callback.onAllMoviesReceived(movie)
        })
    }

    interface LoadTrendingMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<TrendingMovieResults>)
    }

    interface LoadTrendingTvsCallback {
        fun onAllMoviesReceived(movieResponses: List<TrendingTvResults>?)
    }

    interface LoadPopularMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<PopularMovieResults>?)
    }

    interface LoadPopularTvsCallback {
        fun onAllMoviesReceived(movieResponses: List<PopularTvResults>?)
    }
}