package id.mareno.cataloguemovie.model.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "trendingmovie")
@Parcelize
data class TrendingMoviesEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?,

    @SerializedName("genre_ids")
    var genreIds: List<String>?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "posterpath")
    @SerializedName("poster_path")
    var posterPath: String?,

    @ColumnInfo(name = "releasedate")
    @SerializedName("release_date")
    var releaseDate: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "voteaverage")
    @SerializedName("vote_average")
    var voteAverage: Double?,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
) : Parcelable
