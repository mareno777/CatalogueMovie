package id.mareno.cataloguemovie.model.responses


import com.google.gson.annotations.SerializedName
import id.mareno.cataloguemovie.model.json.Genre

data class DetailTvResults(
    @SerializedName("first_air_date")
    var releaseDate: String?,
    var genres: List<Genre>?,
    var id: Int?,
    @SerializedName("name")
    var title: String?,
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int?,
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?
)