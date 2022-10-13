package id.mareno.cataloguemovie.data

import id.mareno.cataloguemovie.data.local.CatalogueDatabase
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.data.remote.CatalogueApi
import id.mareno.cataloguemovie.data.remote.dtos.ComingSoonMovieResults
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.domain.CatalogueRepository
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatalogueRepositoryImpl(
    private val catalogueApi: CatalogueApi,
    private val database: CatalogueDatabase
) : CatalogueRepository {

    private val apiKey = "127c695cd668810b8cf41e5f8429c014"

    override fun getAllTrendingMovies(): Flow<List<PosterResult>> {
        return flow {
            try {
                val response = catalogueApi.getTrendingMovies(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getAllTrendingTvs(): Flow<List<PosterResult>> {
        return flow {
            try {
                val response = catalogueApi.getTrendingTvShows(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getAllPopularMovies(): Flow<List<PosterResult>> {
        return flow {
            try {
                val response = catalogueApi.getPopularMovies(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getAllPopularTvs(): Flow<List<PosterResult>> {
        return flow {
            try {
                val response = catalogueApi.getPopularTvShows(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getDetailMovie(id: Int): Flow<DetailMovieEntity> = flow {
        try {
            val response = catalogueApi.getDetailMovie(id, apiKey)
            val detailMovieEntity = DetailMovieEntity(
                id = response.id,
                title = response.title,
                genres = response.genres.toString(),
                overview = response.overview,
                posterPath = response.posterPath,
                releaseDate = response.releaseDate,
                voteAverage = response.voteAverage
            )
            emit(detailMovieEntity)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getDetailTv(id: Int): Flow<DetailTvEntity> = flow {
        try {
            val response = catalogueApi.getDetailTv(id, apiKey)
            val detailTvEntity = DetailTvEntity(
                id = response.id,
                title = response.title,
                genres = response.genres.toString(),
                overview = response.overview,
                posterPath = response.posterPath,
                releaseDate = response.releaseDate,
                voteAverage = response.voteAverage,
                numberOfSeasons = response.numberOfSeasons.toString(),
                numberOfEpisodes = response.numberOfEpisodes.toString()
            )
            emit(detailTvEntity)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getComingSoon(): Flow<List<ComingSoonMovieResults>> = flow {
        try {
            val response = catalogueApi.getComingSoonMovies(apiKey)
            emit(response.results)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getSearchMovie(query: String): Flow<List<SearchMovieResults>> = flow {
        try {
            val response = catalogueApi.getSearchMovie(query, apiKey)
            emit(response.results)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getBookmarkedMovies(): Flow<List<DetailMovieEntity>> = flow {
        val bookmarkedMovies = database.movieDao().getAllBokmarkedMovies()
        emit(bookmarkedMovies)
    }


    override suspend fun setBookmarkMovie(movie: DetailMovieEntity) {
        database.movieDao().setFavorite(movie)
    }

    override suspend fun deleteBookmarkMovie(movie: DetailMovieEntity) {
        database.movieDao().setUnfavorite(movie)
    }

    override fun getDetailMovieFromRoom(movieId: Int): Flow<DetailMovieEntity> = flow {
        val movie = database.movieDao().getMovieFromRoom(movieId)
        emit(movie)
    }

    override fun getBookmarkedTvs(): Flow<List<DetailTvEntity>> = flow {
        val bookmarkedTvs = database.tvDao().getAllBokmarkedTvs()
        emit(bookmarkedTvs)
    }

    override suspend fun setBookmarkTv(tv: DetailTvEntity) {
        database.tvDao().insertTv(tv)
    }

    override suspend fun deleteBookmarkTv(tv: DetailTvEntity) {
        database.tvDao().deleteTv(tv)
    }

    override fun getDetailTvFromRoom(tvId: Int): Flow<DetailTvEntity> = flow {
        val getDetailTv = database.tvDao().getTvFromRoom(tvId)
        emit(getDetailTv)
    }
}