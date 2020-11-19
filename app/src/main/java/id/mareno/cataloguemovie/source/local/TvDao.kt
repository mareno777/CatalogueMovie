package id.mareno.cataloguemovie.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity

@Dao
interface TvDao {
    @Query("SELECT * FROM detail_tv WHERE id = :tvId")
    fun getTvFromRoom(tvId: Int): LiveData<DetailTvEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTv(tv: DetailTvEntity)

    @Delete
    fun deleteTv(tv: DetailTvEntity)

    @Query("SELECT * FROM detail_tv")
    fun getAllBokmarkedTvs(): DataSource.Factory<Int, DetailTvEntity>
}