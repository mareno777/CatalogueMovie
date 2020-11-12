package id.mareno.cataloguemovie.model.json


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.SearchMovieResults

data class SearchMovieModel(
    var page: Int?,
    var results: ArrayList<SearchMovieResults>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)