package id.mareno.cataloguemovie.source.remote

import androidx.lifecycle.LiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.vo.Resource

interface MovieDataSource {

    fun getAllTrendingMovies(): LiveData<Resource<List<TrendingMoviesEntity>>>

    fun getAllTrendingTvs(): LiveData<List<TrendingTvResults>>

    fun getAllPopularMovies(): LiveData<List<PopularMovieResults>>

    fun getAllPopularTvs(): LiveData<List<PopularTvResults>>

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity>

    fun getDetailTv(id: Int): LiveData<DetailTvEntity>

    fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    fun setTrendingMovieBookmark(movie: TrendingMoviesEntity, state: Boolean)
}