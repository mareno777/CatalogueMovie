package id.mareno.cataloguemovie.model.entities


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail_movie")
data class DetailMovieEntity(

    @ColumnInfo(name = "genres")
    var genres: String?,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "overview")
    var overview: String?,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterPath: String?,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    var releaseDate: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Double?
)