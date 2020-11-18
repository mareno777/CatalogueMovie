package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM detail_movie WHERE id = :movieId")
    fun getMovieFromRoom(movieId: Int): LiveData<DetailMovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movie: DetailMovieEntity)

    @Delete
    fun deleteMovie(movie: DetailMovieEntity)

    @Query("SELECT * FROM detail_movie")
    fun getAllBokmarkedMovie(): LiveData<List<DetailMovieEntity>>

}