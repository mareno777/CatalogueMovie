package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.source.remote.RemoteDataSource

abstract class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {

    override fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>> {
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

    override fun getBookmarkedMovies(): LiveData<List<DetailMovieEntity>> {
        return MutableLiveData()
    }

    override fun setBookmarkMovie(movie: DetailMovieEntity) = Unit

    override fun deleteBookmarkMovie(movie: DetailMovieEntity) = Unit

    override fun getMovieOnRoom(movieId: Int): LiveData<DetailMovieEntity> {
        return MutableLiveData()
    }

    override fun getBookmarkedTvs(): LiveData<List<DetailTvEntity>> {
        TODO("Not yet implemented")
    }

    override fun setBookmarkTv(tv: DetailTvEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteBookmarkTv(tv: DetailTvEntity) {
        TODO("Not yet implemented")
    }

    override fun getTvOnRoom(tvId: Int): LiveData<DetailTvEntity> {
        TODO("Not yet implemented")
    }
}