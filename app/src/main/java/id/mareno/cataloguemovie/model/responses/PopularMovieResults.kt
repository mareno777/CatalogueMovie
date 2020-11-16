package id.mareno.cataloguemovie.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMovieResults(
    var id: Int?,
    @SerializedName("poster_path")
    var posterPath: String?,
    var title: String?
) : Parcelable