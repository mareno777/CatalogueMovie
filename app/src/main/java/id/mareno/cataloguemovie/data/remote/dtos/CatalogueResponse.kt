package id.mareno.cataloguemovie.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class CatalogueResponse<T>(
    val page: Int,

    val results: List<T>,

    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("total_pages")
    val totalPages: Int
)
