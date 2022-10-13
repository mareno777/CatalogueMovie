package id.mareno.cataloguemovie.data.local

import androidx.room.*
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity

@Dao
interface TvDao {
    @Query("SELECT * FROM detail_tv WHERE id = :tvId")
    suspend fun getTvFromRoom(tvId: Int): DetailTvEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTv(tv: DetailTvEntity)

    @Delete
    suspend fun deleteTv(tv: DetailTvEntity)

    @Query("SELECT * FROM detail_tv")
    suspend fun getAllBokmarkedTvs(): List<DetailTvEntity>
}