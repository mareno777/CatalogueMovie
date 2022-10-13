package id.mareno.cataloguemovie.helper.di

import id.mareno.cataloguemovie.model.json.*
import id.mareno.cataloguemovie.model.responses.DetailMovieResults
import id.mareno.cataloguemovie.model.responses.DetailTvResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogueApi {

    @GET("movie/upcoming")
    suspend fun getComingSoonMovies(@Query("api_key") apiKey: String): ComingSoonModel

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): PopularMovieModel

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): PopularTvModel

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String
    ): SearchMovieModel

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(@Query("api_key") apiKey: String): TrendingMovieModel

    @GET("trending/tv/day")
    suspend fun getTrendingTvShows(@Query("api_key") apiKey: String): TrendingTvModel

    @GET("movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): DetailMovieResults

    @GET("tv/{id}")
    suspend fun getDetailTv(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): DetailTvResults
}