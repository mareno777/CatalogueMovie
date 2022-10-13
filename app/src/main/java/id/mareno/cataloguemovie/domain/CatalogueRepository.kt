package id.mareno.cataloguemovie.domain

import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.data.remote.dtos.ComingSoonMovieResults
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import kotlinx.coroutines.flow.Flow

interface CatalogueRepository {

    fun getAllTrendingMovies(): Flow<List<PosterResult>>

    fun getAllTrendingTvs(): Flow<List<PosterResult>>

    fun getAllPopularMovies(): Flow<List<PosterResult>>

    fun getAllPopularTvs(): Flow<List<PosterResult>>

    fun getDetailMovie(id: Int): Flow<DetailMovieEntity>

    fun getDetailTv(id: Int): Flow<DetailTvEntity>

    fun getComingSoon(): Flow<List<ComingSoonMovieResults>>

    fun getSearchMovie(query: String): Flow<List<SearchMovieResults>>

    fun getBookmarkedMovies(): Flow<List<DetailMovieEntity>>

    suspend fun setBookmarkMovie(movie: DetailMovieEntity)

    suspend fun deleteBookmarkMovie(movie: DetailMovieEntity)

    fun getDetailMovieFromRoom(movieId: Int): Flow<DetailMovieEntity>

    fun getBookmarkedTvs(): Flow<List<DetailTvEntity>>

    suspend fun setBookmarkTv(tv: DetailTvEntity)

    suspend fun deleteBookmarkTv(tv: DetailTvEntity)

    fun getDetailTvFromRoom(tvId: Int): Flow<DetailTvEntity>
}