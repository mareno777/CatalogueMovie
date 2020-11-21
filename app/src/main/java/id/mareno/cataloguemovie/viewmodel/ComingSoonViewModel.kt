package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
import id.mareno.cataloguemovie.source.CatalogueRepository

class ComingSoonViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getComingSoonMovies(): LiveData<List<ComingSoonMovieResults>> =
        catalogueRepository.getComingSoon()
}