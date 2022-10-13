package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import id.mareno.cataloguemovie.source.CatalogueRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    private val movieResults = MutableLiveData<List<SearchMovieResults>>()

    fun getResultMovie(searchValue: String) {
        catalogueRepository.getSearchMovie(searchValue)
            .onEach { searchMovieResults ->
                movieResults.postValue(searchMovieResults)
            }
            .launchIn(viewModelScope)

    }

    fun setResultMovie(): LiveData<List<SearchMovieResults>> = movieResults
}