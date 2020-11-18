package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.source.CatalogueRepository

class FavoriteViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun retrieveBookmarkedMovies(): LiveData<List<DetailMovieEntity>> =
        catalogueRepository.getBookmarkedMovies()

    fun retrieveBookmarkedTvs(): LiveData<List<DetailTvEntity>> =
        catalogueRepository.getBookmarkedTvs()
}