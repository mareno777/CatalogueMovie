package id.mareno.cataloguemovie.source.remote

import androidx.lifecycle.LiveData
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

interface MovieDataSource {

    fun getAllTrendingMovies(): LiveData<List<TrendingMovieResults>>

    fun getAllTrendingTvs(): LiveData<List<TrendingTvResults>>

    fun getAllPopularMovies(): LiveData<List<PopularMovieResults>>

    fun getAllPopularTvs(): LiveData<List<PopularTvResults>>

    fun getBookmarkedMovies(): LiveData<List<TrendingMovieResults>>
    fun setMovieBookmark(movie: TrendingMovieResults?, state: Boolean)
}