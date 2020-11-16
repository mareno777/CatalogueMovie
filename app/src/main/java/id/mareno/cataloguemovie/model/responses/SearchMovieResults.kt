package id.mareno.cataloguemovie.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchMovieResults(
    var id: Int?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    var title: String?
) : Parcelable