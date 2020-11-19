package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity

interface CatalogueDataSource {

    fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    fun getAllTrendingTvs(): LiveData<List<TrendingTvsEntity>>

    fun getAllPopularMovies(): LiveData<List<PopularMoviesEntity>>

    fun getAllPopularTvs(): LiveData<List<PopularTvsEntity>>

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity?>

    fun getDetailTv(id: Int): LiveData<DetailTvEntity?>

    fun getBookmarkedMovies(): LiveData<PagedList<DetailMovieEntity>>

    fun setBookmarkMovie(movie: DetailMovieEntity)

    fun deleteBookmarkMovie(movie: DetailMovieEntity)

    fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity>

    fun getBookmarkedTvs(): LiveData<PagedList<DetailTvEntity>>

    fun setBookmarkTv(tv: DetailTvEntity)

    fun deleteBookmarkTv(tv: DetailTvEntity)

    fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity>
}