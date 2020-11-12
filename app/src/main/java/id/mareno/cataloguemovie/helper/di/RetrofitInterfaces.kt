package id.mareno.cataloguemovie.helper.di

import id.mareno.cataloguemovie.BuildConfig
import id.mareno.cataloguemovie.model.entities.*
import retrofit2.Call
import retrofit2.http.GET
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
}