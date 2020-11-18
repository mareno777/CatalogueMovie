package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.source.CatalogueRepository

class HomeViewModel(private val movieRepository: CatalogueRepository) : ViewModel() {

    fun getTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        movieRepository.getAllTrendingMovies()

    fun getTrendingTvs(): LiveData<List<TrendingTvResults>> = movieRepository.getAllTrendingTvs()

    fun getPopularMovies(): LiveData<List<PopularMovieResults>> =
        movieRepository.getAllPopularMovies()

    fun getPopularTvs(): LiveData<List<PopularTvResults>> = movieRepository.getAllPopularTvs()
}