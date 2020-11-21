package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.source.CatalogueRepository

class HomeViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTrendingMovies(): LiveData<List<TrendingMoviesEntity>> =
        catalogueRepository.getAllTrendingMovies()

    fun getTrendingTvs(): LiveData<List<TrendingTvsEntity>> =
        catalogueRepository.getAllTrendingTvs()

    fun getPopularMovies(): LiveData<List<PopularMoviesEntity>> =
        catalogueRepository.getAllPopularMovies()

    fun getPopularTvs(): LiveData<List<PopularTvsEntity>> = catalogueRepository.getAllPopularTvs()
}