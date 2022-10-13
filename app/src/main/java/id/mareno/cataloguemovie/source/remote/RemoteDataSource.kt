package id.mareno.cataloguemovie.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import id.mareno.cataloguemovie.helper.di.CatalogueApi
import id.mareno.cataloguemovie.model.responses.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource private constructor(
    private val catalogueApi: CatalogueApi
) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(
            catalogueApi: CatalogueApi
        ): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(catalogueApi)
            }
    }

    fun getAllTrendingMovies(apiKey: String): LiveData<List<TrendingMovieResults>> {
        return liveData {
            try {
                val response = catalogueApi.getTrendingMovies(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllTrendingTvs(apiKey: String): LiveData<List<TrendingTvResults>> {
        return liveData {
            try {
                val response = catalogueApi.getTrendingTvShows(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllPopularMovies(apiKey: String): LiveData<List<PopularMovieResults>> {
        return liveData {
            try {
                val response = catalogueApi.getPopularMovies(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllPopularTvs(apiKey: String): LiveData<List<PopularTvResults>> {
        return liveData {
            try {
                val response = catalogueApi.getPopularTvShows(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getComingSoon(apiKey: String): LiveData<List<ComingSoonMovieResults>> {
        return liveData {
            try {
                val response = catalogueApi.getComingSoonMovies(apiKey)
                emit(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSearchMovie(query: String, apiKey: String): Flow<List<SearchMovieResults>> = flow {
        try {
            val response = catalogueApi.getSearchMovie(query, apiKey)
            emit(response.results)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getDetailMovie(id: Int, apiKey: String): DetailMovieResults? {
        return try {
            catalogueApi.getDetailMovie(id, apiKey)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getDetailTv(id: Int, apiKey: String): DetailTvResults? {
        return try {
            catalogueApi.getDetailTv(id, apiKey)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}