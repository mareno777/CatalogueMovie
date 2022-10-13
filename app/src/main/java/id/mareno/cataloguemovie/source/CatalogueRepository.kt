package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import kotlinx.coroutines.flow.Flow

interface CatalogueRepository {

    fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    fun getAllTrendingTvs(): LiveData<List<TrendingTvsEntity>>

    fun getAllPopularMovies(): LiveData<List<PopularMoviesEntity>>

    fun getAllPopularTvs(): LiveData<List<PopularTvsEntity>>

    suspend fun getDetailMovie(id: Int): DetailMovieEntity?

    suspend fun getDetailTv(id: Int): DetailTvEntity?

    fun getComingSoon(): LiveData<List<ComingSoonMovieResults>>

    fun getSearchMovie(query: String): Flow<List<SearchMovieResults>>

    fun getBookmarkedMovies(): LiveData<PagedList<DetailMovieEntity>>

    fun setBookmarkMovie(movie: DetailMovieEntity)

    fun deleteBookmarkMovie(movie: DetailMovieEntity)

    fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity>

    fun getBookmarkedTvs(): LiveData<PagedList<DetailTvEntity>>

    fun setBookmarkTv(tv: DetailTvEntity)

    fun deleteBookmarkTv(tv: DetailTvEntity)

    fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity>
}