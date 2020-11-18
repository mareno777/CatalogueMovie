package id.mareno.cataloguemovie.helper.di

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import id.mareno.cataloguemovie.helper.ResponseHelper
import id.mareno.cataloguemovie.source.CatalogueRepository
import id.mareno.cataloguemovie.source.local.CatalogueDatabase
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors

object Repository {

    fun provideRepository(lifecycleOwner: LifecycleOwner, context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ResponseHelper(), lifecycleOwner)
        val appExecutors = AppExecutors()
        val localDataSource = LocalDataSource.getInstance(database.movieDao(), database.tvDao())


        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}