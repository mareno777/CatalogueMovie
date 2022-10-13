package id.mareno.cataloguemovie.data.local

import androidx.room.*
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM detail_movie WHERE id = :movieId")
    suspend fun getMovieFromRoom(movieId: Int): DetailMovieEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setFavorite(movie: DetailMovieEntity)

    @Delete
    suspend fun setUnfavorite(movie: DetailMovieEntity)

    @Query("SELECT * FROM detail_movie")
    suspend fun getAllBokmarkedMovies(): List<DetailMovieEntity>

}