package id.mareno.cataloguemovie.model.entities

import com.google.gson.annotations.SerializedName

data class TrendingMoviesEntity(

    var id: Int?,

    @SerializedName("poster_path")
    var posterPath: String?,

    var title: String?
)
