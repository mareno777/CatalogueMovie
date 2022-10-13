package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors
import kotlinx.coroutines.flow.Flow

class CatalogueRepositoryImpl private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueRepository {

    private val apiKey = "127c695cd668810b8cf41e5f8429c014"

    companion object {
        @Volatile
        private var instance: CatalogueRepositoryImpl? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogueRepository = instance ?: synchronized(this) {
            instance ?: CatalogueRepositoryImpl(remoteData, localDataSource, appExecutors)
        }
    }

    override fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>> {
        return remoteDataSource.getAllTrendingMovies(apiKey).map { trendingMovieResults ->
            trendingMovieResults.map {
                TrendingMoviesEntity(
                    id = it.id, posterPath = it.posterPath, title = it.title
                )
            }
        }
    }

    override fun getAllTrendingTvs(): LiveData<List<TrendingTvsEntity>> {
        return remoteDataSource.getAllTrendingTvs(apiKey).map { trendingTvResults ->
            trendingTvResults.map {
                TrendingTvsEntity(
                    id = it.id, posterPath = it.posterPath, title = it.title
                )
            }
        }
    }

    override fun getAllPopularMovies(): LiveData<List<PopularMoviesEntity>> {
        return remoteDataSource.getAllPopularMovies(apiKey).map { popularMovieResults ->
            popularMovieResults.map {
                PopularMoviesEntity(
                    id = it.id,
                    posterPath = it.posterPath,
                    title = it.title
                )
            }
        }
    }

    override fun getAllPopularTvs(): LiveData<List<PopularTvsEntity>> {
        return remoteDataSource.getAllPopularTvs(apiKey).map { popularTvResults ->
            popularTvResults.map {
                PopularTvsEntity(
                    id = it.id,
                    posterPath = it.posterPath,
                    title = it.title
                )
            }
        }
    }

    override suspend fun getDetailMovie(id: Int): DetailMovieEntity? {
        val detailMovieApi = remoteDataSource.getDetailMovie(id, apiKey) ?: return null
        return DetailMovieEntity(
            id = detailMovieApi.id,
            title = detailMovieApi.title,
            genres = detailMovieApi.genres.toString(),
            overview = detailMovieApi.overview,
            posterPath = detailMovieApi.posterPath,
            releaseDate = detailMovieApi.releaseDate,
            voteAverage = detailMovieApi.voteAverage
        )
    }

    override suspend fun getDetailTv(id: Int): DetailTvEntity? {
        val detailTvApi = remoteDataSource.getDetailTv(id, apiKey) ?: return null
        return DetailTvEntity(
            id = detailTvApi.id,
            title = detailTvApi.title,
            genres = detailTvApi.genres.toString(),
            overview = detailTvApi.overview,
            posterPath = detailTvApi.posterPath,
            releaseDate = detailTvApi.releaseDate,
            voteAverage = detailTvApi.voteAverage,
            numberOfEpisodes = detailTvApi.numberOfEpisodes.toString(),
            numberOfSeasons = detailTvApi.numberOfSeasons.toString()
        )
    }

    override fun getComingSoon(): LiveData<List<ComingSoonMovieResults>> {
        return remoteDataSource.getComingSoon(apiKey)
    }

    override fun getSearchMovie(query: String): Flow<List<SearchMovieResults>> {
        return remoteDataSource.getSearchMovie(query, apiKey)
    }

    override fun getBookmarkedMovies(): LiveData<PagedList<DetailMovieEntity>> {
        val config =
            PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(5)
                .setPageSize(5).build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }


    override fun setBookmarkMovie(movie: DetailMovieEntity) {
        appExecutors.diskIO().execute { localDataSource.insertMovie(movie) }
    }

    override fun deleteBookmarkMovie(movie: DetailMovieEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movie) }
    }

    override fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity> =
        localDataSource.getMovieFromRoom(movieId)

    override fun getBookmarkedTvs(): LiveData<PagedList<DetailTvEntity>> {
        val config =
            PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(5)
                .setPageSize(5).build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvs(), config).build()
    }


    override fun setBookmarkTv(tv: DetailTvEntity) {
        appExecutors.diskIO().execute { localDataSource.insertTv(tv) }
    }

    override fun deleteBookmarkTv(tv: DetailTvEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteTv(tv) }
    }

    override fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity> =
        localDataSource.getTvFromRoom(tvId)

}