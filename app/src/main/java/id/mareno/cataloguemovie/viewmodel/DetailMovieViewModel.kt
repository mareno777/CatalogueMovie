package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.source.CatalogueRepository
import id.mareno.cataloguemovie.ui.activity.DetailActivity.Companion.MOVIE_TYPE
import id.mareno.cataloguemovie.ui.activity.DetailActivity.Companion.TV_TYPE

class DetailMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var movieId: Int = 0

    fun setSelectedMovieId(id: Int) {
        movieId = id
    }

    fun getDetailMovie(): LiveData<DetailMovieEntity> = catalogueRepository.getDetailMovie(movieId)

    fun getDetailTv(): LiveData<DetailTvEntity> = catalogueRepository.getDetailTv(movieId)

    fun getMovieByRoom(): LiveData<DetailMovieEntity> = catalogueRepository.getMovieOnRoom(movieId)

    fun getTvByRoom(): LiveData<DetailTvEntity> = catalogueRepository.getTvOnRoom(movieId)

    fun setBookmark(type: String, state: Boolean, data: Any) {
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