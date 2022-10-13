package id.mareno.cataloguemovie.presentation.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.data.local.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.data.local.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.presentation.viewmodel.DetailMovieViewModel
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
        const val MOVIE_TYPE = "movie_type"
        const val TV_TYPE = "tv_type"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    private var link: String? = null
    private var title: String? = null
    private var image: String? = null
    private var oldDate: String? = null
    private var rating: Double? = null
    private var plot: String? = null
    private var genres: String? = null
    private var movieId = 0
    private var seasons = ""
    private var dataType = ""
    private var episodes = ""
    private var bookmarked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extras = intent.extras

        if (extras != null) {
            startShimmer(true)
            val type = extras.getString(EXTRA_TYPE)
            movieId = extras.getInt(EXTRA_ID, 0)

            if (type == "movie" && movieId != 0) {

                dataType = MOVIE_TYPE

                detailMovieViewModel.getMovieByRoom(movieId).observe(this) { data ->
                    if (data == null) {
                        stateUnbookmarked()
                        populateMovieFromApi()
                    } else {
                        stateBookmarked()
                        populateMovieFromRoom(data)
                    }
                }
                tv_seasons_episodes.visibility = View.GONE
            }


            if (type == "tv" && movieId != 0) {

                dataType = TV_TYPE

                detailMovieViewModel.getTvByRoom(movieId).observe(this) { data ->
                    if (data == null) {
                        stateUnbookmarked()
                        populateTvFromApi()
                    } else {
                        stateBookmarked()
                        populateTvFromRoom(data)
                    }
                }
            }
        }

        btn_back.setOnClickListener {
            finish()
        }

        btn_share.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder.from(this).apply {
                setType(mimeType)
                setChooserTitle("Bagikan film ini sekarang.")
                setText("https://www.themoviedb.org/$link")
                startChooser()
            }
        }

        btn_favorite.setOnClickListener {
            if (dataType == MOVIE_TYPE) {
                bookmarkMovie()
            }

            if (dataType == TV_TYPE) {
                bookmarkTv()
            }
        }

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun populateTvFromRoom(tv: DetailTvEntity) {
        title = tv.title
        image = tv.posterPath
        oldDate = tv.releaseDate
        rating = tv.voteAverage
        plot = tv.overview
        genres = tv.genres.toString()
        seasons = tv.numberOfSeasons.toString()
        episodes = tv.numberOfEpisodes.toString()
        link = "tv/${tv.id}"

        populateDetail()
    }

    private fun populateMovieFromRoom(movie: DetailMovieEntity) {
        title = movie.title
        image = movie.posterPath
        oldDate = movie.releaseDate
        rating = movie.voteAverage
        plot = movie.overview
        genres = movie.genres.toString()
        link = "movie/${movie.id}"

        populateDetail()
    }

    private fun populateTvFromApi() {
        detailMovieViewModel.getDetailTv(movieId).observe(this) { tv ->
            val snackbar =
                Snackbar.make(linear_layout, "Something went wrong", Snackbar.LENGTH_INDEFINITE)

            snackbar.apply {
                setAction("RETRY") { populateTvFromApi() }
                setActionTextColor(ContextCompat.getColor(this@DetailActivity, R.color.colorRed))
            }

            if (tv != null) {
                title = tv.title
                image = tv.posterPath
                oldDate = tv.releaseDate
                rating = tv.voteAverage
                plot = tv.overview
                genres = tv.genres.toString()
                seasons = tv.numberOfSeasons.toString()
                episodes = tv.numberOfEpisodes.toString()
                link = "tv/${tv.id}"
                populateDetail()
            } else {
                snackbar.show()
            }
        }
    }

    private fun populateMovieFromApi() {
        detailMovieViewModel.getDetailMovieFromApi(movieId).observe(this) { movie ->

            val snackbar =
                Snackbar.make(linear_layout, "Something went wrong", Snackbar.LENGTH_INDEFINITE)

            snackbar.apply {
                setAction("RETRY") { populateMovieFromApi() }
                setActionTextColor(ContextCompat.getColor(this@DetailActivity, R.color.colorRed))
            }

            if (movie == null) {
                snackbar.show()
            } else {
                title = movie.title
                image = movie.posterPath
                oldDate = movie.releaseDate
                rating = movie.voteAverage
                plot = movie.overview
                genres = movie.genres.toString()
                link = "movie/${movie.id}"
                populateDetail()
            }
        }
    }

    private fun startShimmer(state: Boolean) {
        if (state) {
            shimmer_detail_activity.visibility = View.VISIBLE
            shimmer_detail_activity.startShimmer()
            constraint_layout.visibility = View.GONE
        } else {
            shimmer_detail_activity.visibility = View.GONE
            shimmer_detail_activity.stopShimmer()
            constraint_layout.visibility = View.VISIBLE
        }
    }

    private fun stateBookmarked() {
        btn_favorite.setIconResource(R.drawable.ic_favorite)
        btn_favorite.iconTint = ContextCompat.getColorStateList(this, R.color.colorRed)
        bookmarked = true
    }

    private fun stateUnbookmarked() {
        btn_favorite.setIconResource(R.drawable.ic_favorite_border)
        btn_favorite.iconTint = ContextCompat.getColorStateList(this, R.color.white)
        bookmarked = false
    }

    private fun bookmarkMovie() {
        val movie = DetailMovieEntity(
            id = movieId,
            title = title,
            overview = plot,
            posterPath = image,
            genres = genres,
            releaseDate = oldDate,
            voteAverage = rating
        )
        if (!bookmarked) {
            detailMovieViewModel.setBookmark(dataType, true, movie)
            stateBookmarked()
        } else {
            detailMovieViewModel.setBookmark(dataType, false, movie)
            stateUnbookmarked()
        }
    }

    private fun bookmarkTv() {
        val tv = DetailTvEntity(
            oldDate,
            genres,
            movieId,
            title,
            episodes,
            seasons,
            plot,
            image,
            rating
        )
        if (!bookmarked) {
            detailMovieViewModel.setBookmark(dataType, true, tv)
        } else {
            detailMovieViewModel.setBookmark(dataType, false, tv)
        }
    }

    private fun populateDetail() {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/original${image}")
            .apply((RequestOptions.bitmapTransform(BlurTransformation(25, 3))))
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    linear_layout.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) = Unit
            })

        startShimmer(false)

        val oldDateFormat = "yyyy-MM-dd"
        val newDateFormat = "dd MMMM yyyy"
        val sdf = SimpleDateFormat(oldDateFormat, Locale.getDefault())

        if (oldDate != null && oldDate.toString().isNotEmpty()) {
            val date = oldDate?.let { oldDate -> sdf.parse(oldDate) }
            sdf.applyPattern(newDateFormat)
            val releaseDate = date?.let { sdf.format(date) }
            tv_release_date.text = releaseDate
        }


        tv_seasons_episodes.text = StringBuilder("$seasons Seasons • $episodes Episodes")
        tv_rating_score.text = StringBuilder("Rating: $rating")
        tv_genres.text = formatedGenres(genres)
        tv_title.text = title
        tv_plot.text = plot

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/original${image}")
            .error(R.drawable.not_found)
            .into(image_inside)
    }

    private fun formatedGenres(rawGenres: String?): String {
        var genres = rawGenres
        if (genres != null) {
            genres = genres.replace("Genre(", "")
            genres = genres.replace(")", "")
            genres = genres.replace("name=", "")
            genres = genres.replace("[", "")
            genres = genres.replace("]", "")
            genres = genres.replace(",", " \u2022")
        } else {
            genres = "Not Available"
        }
        return genres
    }
}