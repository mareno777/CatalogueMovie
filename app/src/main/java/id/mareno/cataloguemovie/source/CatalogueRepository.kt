package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.*
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors

class CatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData, localDataSource, appExecutors)
            }
    }

    override fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>> {
        val movieResults = MutableLiveData<List<TrendingMoviesEntity>>()
        remoteDataSource.getAllTrendingMovies(object : RemoteDataSource.LoadTrendingMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<TrendingMovieResults>) {
                val movieList = ArrayList<TrendingMoviesEntity>()
                for (response in movieResponses) {
                    val movie = TrendingMoviesEntity(
                        response.id,
                        response.posterPath,
                        response.title
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }

        })
        return movieResults
    }

    override fun getAllTrendingTvs(): LiveData<List<TrendingTvResults>> {
        val movieResults = MutableLiveData<List<TrendingTvResults>>()
        remoteDataSource.getAllTrendingTvs(object : RemoteDataSource.LoadTrendingTvsCallback {
            override fun onAllMoviesReceived(movieResponses: List<TrendingTvResults>?) {
                val movieList = ArrayList<TrendingTvResults>()
                if (movieResponses != null) {
                    for (response in movieResponses) {
                        val movie = TrendingTvResults(
                            response.firstAirDate,
                            response.genreIds,
                            response.id,
                            response.title,
                            response.overview,
                            response.posterPath,
                            response.voteAverage
                        )

                        movieList.add(movie)
                    }
                    movieResults.postValue(movieList)
                }
            }

        })
        return movieResults
    }

    override fun getAllPopularMovies(): LiveData<List<PopularMovieResults>> {
        val movieResults = MutableLiveData<List<PopularMovieResults>>()

        remoteDataSource.getAllPopularMovies(object : RemoteDataSource.LoadPopularMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<PopularMovieResults>?) {
                val movieList = ArrayList<PopularMovieResults>()
                if (movieResponses != null) {
                    for (response in movieResponses) {
                        val movie = PopularMovieResults(
                            response.id,
                            response.posterPath,
                            response.title,
                        )
                        movieList.add(movie)
                    }
                    movieResults.postValue(movieList)
                }

            }
        })

        return movieResults
    }

    override fun getAllPopularTvs(): LiveData<List<PopularTvResults>> {
        val movieResults = MutableLiveData<List<PopularTvResults>>()

        remoteDataSource.getAllPopularTvs(object : RemoteDataSource.LoadPopularTvsCallback {
            override fun onAllMoviesReceived(movieResponses: List<PopularTvResults>?) {
                val movieList = ArrayList<PopularTvResults>()
                if (movieResponses != null) {
                    for (response in movieResponses) {
                        val movie = PopularTvResults(
                            response.id,
                            response.title,
                            response.posterPath,
                        )
                        movieList.add(movie)
                    }
                    movieResults.postValue(movieList)
                }
            }

        })
        return movieResults
    }

    override fun getDetailMovie(id: Int): LiveData<DetailMovieEntity> {
        val dataDetailMovie = MutableLiveData<DetailMovieEntity>()

        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovie {
            override fun onDetailMovieReceived(detailMovieResponses: DetailMovieResults) {
                val detail = DetailMovieEntity(
                    detailMovieResponses.genres.toString(),
                    detailMovieResponses.id,
                    detailMovieResponses.overview,
                    detailMovieResponses.posterPath,
                    detailMovieResponses.releaseDate,
                    detailMovieResponses.title,
                    detailMovieResponses.voteAverage
                )
                dataDetailMovie.postValue(detail)
            }
        })
        return dataDetailMovie
    }

    override fun getDetailTv(id: Int): LiveData<DetailTvEntity> {
        val dataDetailTv = MutableLiveData<DetailTvEntity>()

        remoteDataSource.getDetailTv(id, object : RemoteDataSource.LoadDetailTv {
            override fun onDetailTvReceived(detailTvResponses: DetailTvResults) {
                val detail = DetailTvEntity(
                    detailTvResponses.releaseDate,
                    detailTvResponses.genres.toString(),
                    detailTvResponses.id,
                    detailTvResponses.title,
                    detailTvResponses.numberOfEpisodes.toString(),
                    detailTvResponses.numberOfSeasons.toString(),
                    detailTvResponses.overview,
                    detailTvResponses.posterPath,
                    detailTvResponses.voteAverage
                )
                dataDetailTv.postValue(detail)
            }

        })
        return dataDetailTv
    }

    override fun getBookmarkedMovies(): LiveData<List<DetailMovieEntity>> =
        localDataSource.getBookmarkedMovies()


    override fun setBookmarkMovie(movie: DetailMovieEntity) {
        appExecutors.diskIO().execute { localDataSource.insertMovie(movie) }
    }

    override fun deleteBookmarkMovie(movie: DetailMovieEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movie) }
    }

    override fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity> =
        localDataSource.getMovieFromRoom(movieId)

    override fun getBookmarkedTvs(): LiveData<List<DetailTvEntity>> =
        localDataSource.getBookmarkedTvs()


    override fun setBookmarkTv(tv: DetailTvEntity) {
        appExecutors.diskIO().execute { localDataSource.insertTv(tv) }
    }

    override fun deleteBookmarkTv(tv: DetailTvEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteTv(tv) }
    }

    override fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity> =
        localDataSource.getTvFromRoom(tvId)

}