package id.mareno.cataloguemovie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.domain.CatalogueRepository
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

    fun retrieveBookmarkedMovies(): LiveData<List<DetailMovieEntity>> =
        catalogueRepository.getBookmarkedMovies().asLiveData()

    fun retrieveBookmarkedTvs(): LiveData<List<DetailTvEntity>> =
        catalogueRepository.getBookmarkedTvs().asLiveData()
}