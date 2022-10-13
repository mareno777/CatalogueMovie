package id.mareno.cataloguemovie.utils

import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.model.responses.*

object DataDummy {

    fun generateTrendingMovies(): List<TrendingMoviesEntity> {
        val movies = ArrayList<TrendingMoviesEntity>()

        for (i in 0 until 21) {
            movies.add(
                TrendingMoviesEntity(
                    i,
                    "https://m.media-amazon.com/images/M/MV5BM2M2OGJiZTQtOWJkZi00YTdkLWFiOTMtNWZkZDhkOWQ5OTQ1XkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_.jpg",
                    "dummyTitle"
                )

            )
        }

        return movies
    }

    fun generateTrendingTvs(): List<TrendingTvsEntity> {
        val tvShow = ArrayList<TrendingTvsEntity>()

        for (i in 0 until 21) {
            tvShow.add(
                TrendingTvsEntity(
                    i,
                    "title $i",
                    "posterpath"
                )
            )
        }
        return tvShow
    }

    fun generatePopularTvs(): List<PopularTvsEntity> {
        val movie = ArrayList<PopularTvsEntity>()

        for (i in 0 until 21) {

            movie.add(
                PopularTvsEntity(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie

    }

    fun generatePopularMovies(): List<PopularMoviesEntity> {
        val movie = ArrayList<PopularMoviesEntity>()

        for (i in 0 until 21) {

            movie.add(
                PopularMoviesEntity(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie
    }

    fun generateRemoteTrendingMovies(): List<TrendingMovieResults> {
        val movie = ArrayList<TrendingMovieResults>()
        for (i in 0 until 21) {

            movie.add(
                TrendingMovieResults(
                    i,
                    "poster",
                    "title",
                )
            )
        }

        return movie
    }

    fun generateRemoteTrendingTvs(): List<TrendingTvResults> {
        val movie = ArrayList<TrendingTvResults>()
        for (i in 0 until 21) {
            movie.add(
                TrendingTvResults(
                    i,
                    "title $i",
                    "posterpath"
                )
            )
        }
        return movie
    }

    fun generateRemotePopularMovies(): List<PopularMovieResults> {
        val movie = ArrayList<PopularMovieResults>()

        for (i in 0 until 21) {

            movie.add(
                PopularMovieResults(
                    i,
                    "poster",
                    "Fake Title",
                )
            )
        }
        return movie
    }

    fun generateRemotePopularTvs(): List<PopularTvResults> {
        val movie = ArrayList<PopularTvResults>()

        for (i in 0 until 21) {

            movie.add(
                PopularTvResults(
                    i,
                    "tilte",
                    "poster",
                )
            )
        }
        return movie

    }

    fun generateComingSoon(): List<ComingSoonMovieResults> {
        val movie = ArrayList<ComingSoonMovieResults>()

        for (i in 0 until 21) {
            movie.add(
                ComingSoonMovieResults(
                    "https://www.example.com/$i",
                    listOf(i),
                    i,
                    "Overview $i",
                    "$i-12-2002",
                    "Title $i"
                )
            )
        }
        return movie
    }

    fun generateDetailMovie(): DetailMovieEntity {
        return DetailMovieEntity(
            9,
            "title",
            "overview",
            "overView",
            "https://example.com",
            "19-07-2020",
            7.2
        )
    }

    fun generateDetailTv(): DetailTvEntity {
        return DetailTvEntity(
            "19-07-2020",
            "Drama",
            9,
            "Title",
            "40",
            "6",
            "Overview",
            "https://example.com/",
            7.2
        )
    }
}
