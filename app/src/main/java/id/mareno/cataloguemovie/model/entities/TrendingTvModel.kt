package id.mareno.cataloguemovie.model.entities


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.responses.TrendingTvResults

data class TrendingTvModel(
    var page: Int?,
    var results: ArrayList<TrendingTvResults>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)