package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity

class LocalDataSource private constructor(
    private val mMovieDao: MovieDao,
    private val mTvDao: TvDao
) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao, tvDao: TvDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao, tvDao)
    }

    fun getBookmarkedMovies(): DataSource.Factory<Int, DetailMovieEntity> =
        mMovieDao.getAllBokmarkedMovie()

    fun getMovieFromRoom(movieId: Int): LiveData<DetailMovieEntity> =
        mMovieDao.getMovieFromRoom(movieId)

    fun insertMovie(movie: DetailMovieEntity) = mMovieDao.insertMovie(movie)

    fun deleteMovie(movie: DetailMovieEntity) = mMovieDao.deleteMovie(movie)

    fun getBookmarkedTvs(): DataSource.Factory<Int, DetailTvEntity> = mTvDao.getAllBokmarkedTvs()

    fun getTvFromRoom(tvId: Int): LiveData<DetailTvEntity> = mTvDao.getTvFromRoom(tvId)

    fun insertTv(tv: DetailTvEntity) = mTvDao.insertTv(tv)

    fun deleteTv(tv: DetailTvEntity) = mTvDao.deleteTv(tv)
}