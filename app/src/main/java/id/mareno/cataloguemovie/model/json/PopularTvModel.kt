package id.mareno.cataloguemovie.model.json


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.PopularTvResults

data class PopularTvModel(
    var page: Int?,
    var results: ArrayList<PopularTvResults>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)