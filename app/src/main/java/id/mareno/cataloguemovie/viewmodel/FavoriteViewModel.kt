package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.source.CatalogueRepository

class FavoriteViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun retrieveBookmarkedMovies(): LiveData<PagedList<DetailMovieEntity>> =
        catalogueRepository.getBookmarkedMovies()

    fun retrieveBookmarkedTvs(): LiveData<PagedList<DetailTvEntity>> =
        catalogueRepository.getBookmarkedTvs()
}