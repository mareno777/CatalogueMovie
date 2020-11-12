package id.mareno.cataloguemovie.model.entities


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults

data class TrendingMovieModel(
    var page: Int?,
    var results: ArrayList<TrendingMovieResults>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)