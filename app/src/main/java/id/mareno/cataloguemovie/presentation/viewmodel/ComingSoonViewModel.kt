package id.mareno.cataloguemovie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.mareno.cataloguemovie.data.remote.dtos.ComingSoonMovieResults
import id.mareno.cataloguemovie.domain.CatalogueRepository
import javax.inject.Inject

@HiltViewModel
class ComingSoonViewModel @Inject constructor(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

    fun getComingSoonMovies(): LiveData<List<ComingSoonMovieResults>> =
        catalogueRepository.getComingSoon().asLiveData()
}