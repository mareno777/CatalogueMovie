package id.mareno.cataloguemovie.model.entities.list


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularTvsEntity(
    var id: Int?,

    @SerializedName("name")
    var title: String?,

    @SerializedName("poster_path")
    var posterPath: String?,
) : Parcelable