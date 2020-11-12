package id.mareno.cataloguemovie.model.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class TrendingMovieResults(
    @SerializedName("genre_ids")
    var genreIds: List<String>?,
    var id: Int?,
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var title: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
) : Parcelable