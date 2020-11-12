package id.mareno.cataloguemovie.helper.di

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import id.mareno.cataloguemovie.helper.ResponseHelper
import id.mareno.cataloguemovie.source.MovieRepository
import id.mareno.cataloguemovie.source.local.LocalDataSource
import id.mareno.cataloguemovie.source.local.MovieDatabase
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.AppExecutors

object Repository {

    fun provideRepository(lifecycleOwner: LifecycleOwner, context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ResponseHelper(), lifecycleOwner)
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()


        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}