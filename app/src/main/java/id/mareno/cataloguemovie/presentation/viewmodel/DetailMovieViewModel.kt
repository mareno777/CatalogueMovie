package id.mareno.cataloguemovie.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.domain.CatalogueRepository
import id.mareno.cataloguemovie.presentation.activity.DetailActivity.Companion.MOVIE_TYPE
import id.mareno.cataloguemovie.presentation.activity.DetailActivity.Companion.TV_TYPE
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val catalogueRepository: CatalogueRepository
) : ViewModel() {

    fun getDetailMovieFromApi(movieId: Int): LiveData<DetailMovieEntity> {
        return catalogueRepository.getDetailMovie(movieId).asLiveData()
    }

    fun getDetailTv(movieId: Int): LiveData<DetailTvEntity> {
        return catalogueRepository.getDetailTv(movieId).asLiveData()
    }

    fun getMovieByRoom(movieId: Int): LiveData<DetailMovieEntity> {
        return catalogueRepository.getDetailMovieFromRoom(movieId).asLiveData()
    }

    fun getTvByRoom(movieId: Int): LiveData<DetailTvEntity> {
        return catalogueRepository.getDetailTvFromRoom(movieId).asLiveData()
    }

    fun setBookmark(type: String, state: Boolean, data: Any) {
        viewModelScope.launch {
            when (type) {
                MOVIE_TYPE -> {
                    if (state) {
                        catalogueRepository.setBookmarkMovie(data as DetailMovieEntity)
                    } else {
                        catalogueRepository.deleteBookmarkMovie(data as DetailMovieEntity)
                    }
                }
                TV_TYPE -> {
                    if (state) {
                        catalogueRepository.setBookmarkTv(data as DetailTvEntity)
                    } else {
                        catalogueRepository.deleteBookmarkTv(data as DetailTvEntity)
                    }
                }
            }
        }
    }
}