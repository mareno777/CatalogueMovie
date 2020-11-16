package id.mareno.cataloguemovie.ui.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.snackbar.Snackbar
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.viewmodel.DetailMovieViewModel
import id.mareno.cataloguemovie.viewmodel.ViewModelFactory
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailMovieViewModel: DetailMovieViewModel

    private var link: String? = null
    private var title: String? = null
    private var image: String? = null
    private var oldDate: String? = null
    private var rating: String? = null
    private var plot: String? = null
    private var genres: String? = null
    private var seasons = ""
    private var episodes = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val factory = ViewModelFactory.getInstance(this, this)

        detailMovieViewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val type = extras.getString(EXTRA_TYPE)
            val movieId = extras.getInt(EXTRA_ID, 0)
            if (type == "movie" && movieId != 0) {

                tv_seasons_episodes.visibility = View.GONE
                detailMovieViewModel.setSelectedMovieId(movieId)

                detailMovieViewModel.getDetailMovie().observe(this, { movie ->
                    title = movie.title
                    image = "https://image.tmdb.org/t/p/original${movie.posterPath}"
                    oldDate = movie.releaseDate
                    rating = movie.voteAverage.toString()
                    plot = movie.overview
                    genres = movie.genres.toString()
                    link = "movie/${movie.id.toString()}"

                    populateDetail()
                })
            }

            if (type == "tv" && movieId != 0) {
                detailMovieViewModel.setSelectedMovieId(movieId)

                detailMovieViewModel.getDetailTv().observe(this, { movie ->
                    title = movie.title
                    image = "https://image.tmdb.org/t/p/original${movie.posterPath}"
                    oldDate = movie.releaseDate
                    rating = movie.voteAverage.toString()
                    plot = movie.overview
                    genres = movie.genres.toString()
                    seasons = movie.numberOfSeasons.toString()
                    episodes = movie.numberOfEpisodes.toString()
                    link = "tv/${movie.id.toString()}"

                    populateDetail()
                })
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

        btn_favorite.setOnClickListener { view ->
            Snackbar.make(
                view,
                getString(R.string.coming_soon),
                Snackbar.LENGTH_SHORT
            ).show()
        }

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun populateDetail() {

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
            .load(image)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 15)))
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    constraint_layout.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) = Unit
            })

        Glide.with(this)
            .load(image)
            .error(R.drawable.not_found)
            .into(image_inside)
    }

    private fun setBookmarkState(state: Boolean?) {
        if (state == null) return
        if (state) {
            btn_favorite.setIconResource(R.drawable.ic_favorite)
        } else {
            btn_favorite.setIconResource(R.drawable.ic_favorite_border)
        }
    }

    private fun formatedGenres(rawGenres: String?): String? {
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