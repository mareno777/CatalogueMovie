package id.mareno.cataloguemovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity

@Database(
    entities = [DetailMovieEntity::class, DetailTvEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CatalogueDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}