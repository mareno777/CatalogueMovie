package id.mareno.cataloguemovie.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.data.local.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.data.local.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.data.local.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.data.local.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.data.remote.dtos.ComingSoonMovieResults
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.domain.CatalogueRepository
import id.mareno.cataloguemovie.model.responses.*
import id.mareno.cataloguemovie.source.remote.RemoteDataSource

class FakeCatalogueRepository(
    private val remoteDataSource: RemoteDataSource
) :
    CatalogueRepository {

    override fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>> {
        val movieResults = MutableLiveData<List<TrendingMoviesEntity>>()
        remoteDataSource.getAllTrendingMovies(object : RemoteDataSource.LoadTrendingMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<TrendingMovieResults>) {
                val movieList = ArrayList<TrendingMoviesEntity>()
                for (response in movieResponses) {
                    val movie = TrendingMoviesEntity(
                        response.id,
                        response.title,
                        response.posterPath
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTrendingTvs(): LiveData<List<TrendingTvsEntity>> {
        val movieResults = MutableLiveData<List<TrendingTvsEntity>>()
        remoteDataSource.getAllTrendingTvs(object : RemoteDataSource.LoadTrendingTvsCallback {
            override fun onAllMoviesReceived(movieResponses: List<TrendingTvResults>) {
                val movieList = ArrayList<TrendingTvsEntity>()
                for (response in movieResponses) {
                    val movie = TrendingTvsEntity(
                        response.id,
                        response.title,
                        response.posterPath
                    )

                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }

        })
        return movieResults
    }

    override fun getAllPopularMovies(): LiveData<List<PopularMoviesEntity>> {
        val movieResults = MutableLiveData<List<PopularMoviesEntity>>()

        remoteDataSource.getAllPopularMovies(object : RemoteDataSource.LoadPopularMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<PosterResult>) {
                val movieList = ArrayList<PopularMoviesEntity>()
                for (response in movieResponses) {
                    val movie = PopularMoviesEntity(
                        response.id,
                        response.posterPath,
                        response.title,
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)

            }
        })

        return movieResults
    }

    override fun getAllPopularTvs(): LiveData<List<PopularTvsEntity>> {
        val movieResults = MutableLiveData<List<PopularTvsEntity>>()

        remoteDataSource.getAllPopularTvs(object : RemoteDataSource.LoadPopularTvsCallback {
            override fun onAllMoviesReceived(movieResponses: List<PopularTvResults>) {
                val movieList = ArrayList<PopularTvsEntity>()
                for (response in movieResponses) {
                    val movie = PopularTvsEntity(
                        response.id,
                        response.title,
                        response.posterPath
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }

        })
        return movieResults
    }

    override fun getDetailMovie(id: Int): LiveData<DetailMovieEntity?> {
        val dataDetailMovie = MutableLiveData<DetailMovieEntity?>()

        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovie {
            override fun onDetailMovieReceived(detailMovieResponses: DetailMovieResults?) {
                if (detailMovieResponses == null) {
                    dataDetailMovie.postValue(null)
                } else {
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
            }
        })
        return dataDetailMovie
    }

    override fun getDetailTv(id: Int): LiveData<DetailTvEntity?> {
        return MutableLiveData()
    }

    override fun getComingSoon(): LiveData<List<ComingSoonMovieResults>> {
        val movieResults = MutableLiveData<List<ComingSoonMovieResults>>()

        remoteDataSource.getComingSoon(object : RemoteDataSource.LoadComingSoon {
            override fun onAllMoviesReceived(movieResponses: List<ComingSoonMovieResults>) {
                movieResults.postValue(movieResponses)
            }

        })
        return movieResults
    }

    override fun getBookmarkedMovies(): LiveData<PagedList<DetailMovieEntity>> {
        return MutableLiveData()
    }

    override fun setBookmarkMovie(movie: DetailMovieEntity) = Unit

    override fun deleteBookmarkMovie(movie: DetailMovieEntity) = Unit

    override fun getDetailMovieFromRoom(movieId: Int): LiveData<DetailMovieEntity> {
        return MutableLiveData()
    }

    override fun getBookmarkedTvs(): LiveData<PagedList<DetailTvEntity>> {
        return MutableLiveData()
    }

    override fun setBookmarkTv(tv: DetailTvEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteBookmarkTv(tv: DetailTvEntity) {
        TODO("Not yet implemented")
    }

    override fun getDetailTvFromRoom(tvId: Int): LiveData<DetailTvEntity> {
        return MutableLiveData()
    }
}