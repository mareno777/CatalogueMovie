package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
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
        return object : NetworkBoundResource<List<TrendingMoviesEntity>, List<TrendingMovieResults>>(appExecutors) {
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
                            response.genreIds,
                            response.id,
                            response.overview,
                            response.posterPath,
                            response.releaseDate,
                            response.title,
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

    override fun getAllPopularTvs(): LiveData<List<PopularTvResults>> {
        val movieResults = MutableLiveData<List<PopularTvResults>>()

        remoteDataSource.getAllPopularTvs(object : RemoteDataSource.LoadPopularTvsCallback {
            override fun onAllMoviesReceived(movieResponses: List<PopularTvResults>?) {
                val movieList = ArrayList<PopularTvResults>()
                if (movieResponses != null) {
                    for (response in movieResponses) {
                        val movie = PopularTvResults(
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

    override fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        localDataSource.getBookmarkedTrendingMovies()

    override fun setTrendingMovieBookmark(movie: TrendingMoviesEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTrendingMovieBookmark(movie, state) }
    }

}