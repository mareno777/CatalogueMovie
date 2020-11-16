package id.mareno.cataloguemovie.model.responses


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.json.Genre

data class DetailMovieResults(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    var genres: List<Genre>?,
    var id: Int?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var title: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?
)