package id.mareno.cataloguemovie.model.entities

import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.PopularMovieResults

class PopularMovieModel {
    @SerializedName("results")
    private lateinit var popularMovieResults: ArrayList<PopularMovieResults>

    fun getPopularMovieResults(): ArrayList<PopularMovieResults>? {
        return popularMovieResults
    }
}