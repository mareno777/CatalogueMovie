package id.mareno.cataloguemovie.helper.di

import android.content.Context
import id.mareno.cataloguemovie.source.CatalogueRepository
import id.mareno.cataloguemovie.source.CatalogueRepositoryImpl
import id.mareno.cataloguemovie.source.local.CatalogueDatabase
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors

object Repository {

    fun provideRepository(context: Context): CatalogueRepository {

        val catalogueApi = RetrofitBuilder.getApiClient()
        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(catalogueApi)
        val appExecutors = AppExecutors()
        val localDataSource = LocalDataSource.getInstance(database.movieDao(), database.tvDao())


        return CatalogueRepositoryImpl.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}