package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.*
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.remote.ApiResponse
import id.mareno.cataloguemovie.source.remote.MovieDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors
import id.mareno.cataloguemovie.vo.Resource

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTrendingMovies(): LiveData<Resource<List<TrendingMoviesEntity>>> {
        return object :
            NetworkBoundResource<List<TrendingMoviesEntity>, List<TrendingMovieResults>>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<List<TrendingMoviesEntity>> =
                localDataSource.getAllTrendingMovies()


            override fun shouldFetch(data: List<TrendingMoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TrendingMovieResults>>> =
                remoteDataSource.getAllTrendingMovies()


            override fun saveCallResult(data: List<TrendingMovieResults>) {
                val movieList = ArrayList<TrendingMoviesEntity>()
                for (response in data) {
                    val movie = TrendingMoviesEntity(
                        response.id,
                        response.genreIds,
                        response.overview,
                        response.posterPath,
                        response.releaseDate,
                        response.title,
                        response.voteAverage,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertTrendingMovies(movieList)
            }

        }.asLiveData()
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
                    detailMovieResponses.backdropPath,
                    detailMovieResponses.genres,
                    detailMovieResponses.id,
                    detailMovieResponses.originalLanguage,
                    detailMovieResponses.overview,
                    detailMovieResponses.posterPath,
                    detailMovieResponses.releaseDate,
                    detailMovieResponses.title,
                    detailMovieResponses.voteAverage,
                    detailMovieResponses.voteCount,
                    false
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
                    detailTvResponses.genres,
                    detailTvResponses.id,
                    detailTvResponses.title,
                    detailTvResponses.numberOfEpisodes,
                    detailTvResponses.numberOfSeasons,
                    detailTvResponses.overview,
                    detailTvResponses.posterPath,
                    detailTvResponses.voteAverage,
                    false
                )
                dataDetailTv.postValue(detail)
            }

        })
        return dataDetailTv
    }

    override fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        localDataSource.getBookmarkedTrendingMovies()

    override fun setTrendingMovieBookmark(movie: TrendingMoviesEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTrendingMovieBookmark(movie, state) }
    }

}