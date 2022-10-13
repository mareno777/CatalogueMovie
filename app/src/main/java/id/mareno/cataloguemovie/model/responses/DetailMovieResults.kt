package id.mareno.cataloguemovie.model.responses


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.data.remote.dtos.Genre

data class DetailMovieResults(
    var genres: List<Genre>?,
    var id: Int,
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var title: String,
    @SerializedName("vote_average")
    var voteAverage: Double?
)