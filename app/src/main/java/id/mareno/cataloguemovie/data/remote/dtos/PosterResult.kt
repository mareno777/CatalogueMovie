package id.mareno.cataloguemovie.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class PosterResult(
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String?,

    val title: String?
)