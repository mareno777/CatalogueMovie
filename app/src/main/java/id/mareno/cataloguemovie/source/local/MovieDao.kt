package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults

@Dao
interface MovieDao {

    @Query("SELECT * FROM trendingmovie")
    fun getAllTrendingMovies(): LiveData<List<TrendingMovieResults>>

    @Query("SELECT * FROM trendingmovie where bookmarked = 1")
    fun getBookmarkedTrendingMovies(): LiveData<List<TrendingMovieResults>>

    @Transaction
    @Query("SELECT * FROM trendingmovie WHERE id = :id")
    fun getTrendingMoviesWithId(id: String): LiveData<TrendingMovieResults>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrendingMovie(movie: List<TrendingMovieResults>)

    @Update
    fun updateTrendingMovie(movie: TrendingMovieResults)

    @Delete
    fun deleteTrendingMovie(movie: TrendingMovieResults)



}