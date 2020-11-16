package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.source.remote.MovieDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.vo.Resource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    override fun getAllTrendingMovies(): LiveData<Resource<List<TrendingMoviesEntity>>> {
        return MutableLiveData()
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
                            response.posterPath
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
        return MutableLiveData()
    }

    override fun getDetailTv(id: Int): LiveData<DetailTvEntity> {
        return MutableLiveData()
    }

    override fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        MutableLiveData()

    override fun setTrendingMovieBookmark(movie: TrendingMoviesEntity, state: Boolean) {}
}