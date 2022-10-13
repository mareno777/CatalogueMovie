package id.mareno.cataloguemovie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.mareno.cataloguemovie.domain.CatalogueRepository
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

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