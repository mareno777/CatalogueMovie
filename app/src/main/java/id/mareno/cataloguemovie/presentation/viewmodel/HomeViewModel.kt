package id.mareno.cataloguemovie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.domain.CatalogueRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

    fun getTrendingMovies(): LiveData<List<PosterResult>> =
        catalogueRepository.getAllTrendingMovies().asLiveData()

    fun getTrendingTvs(): LiveData<List<PosterResult>> =
        catalogueRepository.getAllTrendingTvs().asLiveData()

    fun getPopularMovies(): LiveData<List<PosterResult>> =
        catalogueRepository.getAllPopularMovies().asLiveData()

    fun getPopularTvs(): LiveData<List<PosterResult>> =
        catalogueRepository.getAllPopularTvs().asLiveData()
}