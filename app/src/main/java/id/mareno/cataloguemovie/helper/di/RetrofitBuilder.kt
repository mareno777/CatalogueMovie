package id.mareno.cataloguemovie.helper.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"

object RetrofitBuilder {

    fun getApiClient(): CatalogueApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatalogueApi::class.java)
    }
}