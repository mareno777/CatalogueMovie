package id.mareno.cataloguemovie.helper.di

import id.mareno.cataloguemovie.BuildConfig
import id.mareno.cataloguemovie.model.json.*
import id.mareno.cataloguemovie.model.responses.DetailMovieResults
import id.mareno.cataloguemovie.model.responses.DetailTvResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object RetrofitInterfaces {

    interface ComingSoonApi {
        @GET(
            "movie/upcoming?api_key=${
                BuildConfig.API_KEY
            }"
        )
        fun getComingSoonMovies(): Call<ComingSoonModel>
    }

    interface PopularMoviesApi {
        @GET(
            "movie/popular?api_key=${
                BuildConfig.API_KEY
            }"
        )
        fun getPopularMovies(): Call<PopularMovieModel>
    }

    interface PopularTvApi {
        @GET(
            "tv/popular?api_key=${
                BuildConfig.API_KEY
            }"
        )
        fun getPopularTvShows(): Call<PopularTvModel>
    }

    interface SearchMovieApi {
        @GET(
            "search/movie"
        )
        fun getSearchMovie(
            @Query("api_key") apiKey: String,
            @Query("query") query: String
        ): Call<SearchMovieModel>
    }

    interface TrendingMoviesApi {
        @GET(
            "trending/movie/day?api_key=${
                BuildConfig.API_KEY
            }"
        )
        fun getTrendingMovies(): Call<TrendingMovieModel>
    }

    interface TrendingTvApi {
        @GET(
            "trending/tv/day?api_key=${
                BuildConfig.API_KEY
            }"
        )
        fun getTrendingTvShows(): Call<TrendingTvModel>
    }

    interface DetailMovie {
        @GET("movie/{id}?api_key=${BuildConfig.API_KEY}")
        fun getDetailMovie(
            @Path("id") id: Int
        ): Call<DetailMovieResults>
    }

    interface DetailTv {
        @GET("tv/{id}?api_key=${BuildConfig.API_KEY}")
        fun getDetailTv(
            @Path("id") id: Int
        ): Call<DetailTvResults>
    }
}