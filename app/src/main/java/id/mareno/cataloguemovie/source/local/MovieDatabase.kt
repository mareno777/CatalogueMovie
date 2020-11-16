package id.mareno.cataloguemovie.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.mareno.cataloguemovie.helper.DataConverter
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity

@Database(
    entities = [TrendingMoviesEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(DataConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "Movies.db"
                ).build()
            }
    }
}