package id.mareno.cataloguemovie.data.remote

import id.mareno.cataloguemovie.data.remote.dtos.CatalogueResponse
import id.mareno.cataloguemovie.data.remote.dtos.ComingSoonMovieResults
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.model.responses.DetailMovieResults
import id.mareno.cataloguemovie.model.responses.DetailTvResults
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogueApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): CatalogueResponse<PosterResult>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): CatalogueResponse<PosterResult>

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(@Query("api_key") apiKey: String): CatalogueResponse<PosterResult>

    @GET("trending/tv/day")
    suspend fun getTrendingTvShows(@Query("api_key") apiKey: String): CatalogueResponse<PosterResult>

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String
    ): CatalogueResponse<SearchMovieResults>

    @GET("movie/upcoming")
    suspend fun getComingSoonMovies(@Query("api_key") apiKey: String): CatalogueResponse<ComingSoonMovieResults>

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