package id.mareno.cataloguemovie.model.entities.list


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularMoviesEntity(
    var id: Int?,
    @SerializedName("poster_path")
    var posterPath: String?,
    var title: String?
) : Parcelable