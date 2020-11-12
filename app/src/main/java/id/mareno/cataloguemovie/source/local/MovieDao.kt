package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM trendingmovie")
    fun getAllTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    @Query("SELECT * FROM trendingmovie where bookmarked = 1")
    fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMoviesEntity>>

    @Transaction
    @Query("SELECT * FROM trendingmovie WHERE id = :id")
    fun getTrendingMoviesWithId(id: String): LiveData<TrendingMoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrendingMovie(movie: List<TrendingMoviesEntity>)

    @Update
    fun updateTrendingMovie(movie: TrendingMoviesEntity)
}