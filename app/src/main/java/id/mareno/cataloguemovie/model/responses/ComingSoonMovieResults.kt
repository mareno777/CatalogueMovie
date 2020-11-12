package id.mareno.cataloguemovie.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComingSoonMovieResults(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    var id: Int?,
    var overview: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var title: String?
) : Parcelable