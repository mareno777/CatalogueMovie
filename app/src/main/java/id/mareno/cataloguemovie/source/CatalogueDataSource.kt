package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

interface CatalogueDataSource {

    fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    fun getAllTrendingTvs(): LiveData<List<TrendingTvResults>>

    fun getAllPopularMovies(): LiveData<List<PopularMovieResults>>

    fun getAllPopularTvs(): LiveData<List<PopularTvResults>>

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity>

    fun getDetailTv(id: Int): LiveData<DetailTvEntity>

    fun getBookmarkedMovies(): LiveData<List<DetailMovieEntity>>

    fun setBookmarkMovie(movie: DetailMovieEntity)

    fun deleteBookmarkMovie(movie: DetailMovieEntity)

    fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity>

    fun getBookmarkedTvs(): LiveData<List<DetailTvEntity>>

    fun setBookmarkTv(tv: DetailTvEntity)

    fun deleteBookmarkTv(tv: DetailTvEntity)

    fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity>
}