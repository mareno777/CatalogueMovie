package id.mareno.cataloguemovie.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrendingTvResults(
    @SerializedName("first_air_date")
    var firstAirDate: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    var id: Int?,
    @SerializedName("name")
    var title: String?,
    var overview: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?
) : Parcelable