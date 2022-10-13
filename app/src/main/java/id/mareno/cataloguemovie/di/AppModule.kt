package id.mareno.cataloguemovie.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.mareno.cataloguemovie.MyApplication
import id.mareno.cataloguemovie.data.CatalogueRepositoryImpl
import id.mareno.cataloguemovie.data.local.CatalogueDatabase
import id.mareno.cataloguemovie.data.remote.CatalogueApi
import id.mareno.cataloguemovie.domain.CatalogueRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCatalogueApi(): CatalogueApi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatalogueApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application): CatalogueDatabase {
        return Room.databaseBuilder(
            app,
            CatalogueDatabase::class.java,
            "Catalogue.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCatalogueRepository(
        catalogueApi: CatalogueApi,
        database: CatalogueDatabase
    ): CatalogueRepository {
        return CatalogueRepositoryImpl(
            catalogueApi = catalogueApi,
            database = database
        )
    }
}