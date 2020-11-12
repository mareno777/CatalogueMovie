package id.mareno.cataloguemovie.model.json


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults

data class ComingSoonModel(
    var page: Int?,
    var results: ArrayList<ComingSoonMovieResults>?,
    @SerializedName("total_pages")
    var totalPages: Int?
)