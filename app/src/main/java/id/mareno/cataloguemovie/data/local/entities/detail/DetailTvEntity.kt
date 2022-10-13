package id.mareno.cataloguemovie.data.local.entities.detail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "detail_tv")
data class DetailTvEntity(

    @ColumnInfo(name = "release_date")
    @SerializedName("first_air_date")
    var releaseDate: String?,

    @ColumnInfo(name = "genres")
    var genres: String?,

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "title")
    @SerializedName("name")
    var title: String?,

    @ColumnInfo(name = "episodes")
    @SerializedName("number_of_episodes")
    var numberOfEpisodes: String?,

    @ColumnInfo(name = "seasons")
    @SerializedName("number_of_seasons")
    var numberOfSeasons: String?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String?,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double?
)