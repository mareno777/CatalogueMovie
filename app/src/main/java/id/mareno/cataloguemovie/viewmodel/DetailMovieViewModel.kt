package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.source.MovieRepository

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    var movieId: Int = 0

    fun setSelectedMovieId(id: Int) {
        movieId = id
    }

    fun getDetailMovie(): LiveData<DetailMovieEntity> = movieRepository.getDetailMovie(movieId)

    fun getDetailTv(): LiveData<DetailTvEntity> = movieRepository.getDetailTv(movieId)

}