package id.mareno.cataloguemovie.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var title: String? = null,
    var image: String? = null,
    var releaseDate: String? = null,
    var rating: String? = null,
    var plot: String? = null,
    var genre: String? = null,
    var numberOfEpisodes: String? = null
) : Parcelable
