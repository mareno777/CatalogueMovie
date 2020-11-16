package id.mareno.cataloguemovie.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularTvResults(
    var id: Int?,
    @SerializedName("name")
    var title: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
) : Parcelable