package id.mareno.cataloguemovie.ui.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.MOVE_ACTIVITY
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.POPULAR_MOVIE
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.POPULAR_TV
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.SEARCH_MOVIE
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.TRENDING_MOVIE
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.TRENDING_TV
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    private var trendingMovie: TrendingMoviesEntity? = null
    private var searchMovie: SearchMovieResults? = null
    private var trendingTvShow: TrendingTvResults? = null
    private var popularMovieResults: PopularMovieResults? = null
    private var popularTv: PopularTvResults? = null

    private var link: String? = null
    private var title: String? = null
    private var image: String? = null
    private var oldDate: String? = null
    private var rating: String? = null
    private var plot: String? = null
    private var genres: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val oldDateFormat = "yyyy-MM-dd"
        val newDateFormat = "dd MMMM yyyy"

        val bundle = intent.getBundleExtra(MOVE_ACTIVITY)
        trendingMovie = bundle?.getParcelable(TRENDING_MOVIE)
        trendingTvShow = bundle?.getParcelable(TRENDING_TV)
        popularMovieResults = bundle?.getParcelable(POPULAR_MOVIE)
        popularTv = bundle?.getParcelable(POPULAR_TV)
        searchMovie = bundle?.getParcelable(SEARCH_MOVIE)


        if (trendingMovie != null) {
            link = "movie/${trendingMovie?.id.toString()}"
            title = trendingMovie?.title
            image = "https://image.tmdb.org/t/p/original${trendingMovie?.posterPath}"
            oldDate = trendingMovie?.releaseDate
            rating = trendingMovie?.voteAverage.toString()
            plot = trendingMovie?.overview
            genres = trendingMovie?.genreIds.toString()

        }

        if (searchMovie != null) {
            link = "movie/${searchMovie?.id.toString()}"
            title = searchMovie?.title
            image = "https://image.tmdb.org/t/p/original${searchMovie?.posterPath}"
            oldDate = searchMovie?.releaseDate
            rating = searchMovie?.voteAverage.toString()
            plot = searchMovie?.overview
            genres = searchMovie?.genreIds.toString()
        }

        if (trendingTvShow != null) {
            link = "tv/${trendingTvShow?.id.toString()}"
            title = trendingTvShow?.title
            image = "https://image.tmdb.org/t/p/original${trendingTvShow?.posterPath}"
            oldDate = trendingTvShow?.firstAirDate
            rating = trendingTvShow?.voteAverage.toString()
            plot = trendingTvShow?.overview
            genres = trendingTvShow?.genreIds.toString()
        }

        if (popularMovieResults != null) {
            link = "movie/${popularMovieResults?.id.toString()}"
            title = popularMovieResults?.title
            image = "https://image.tmdb.org/t/p/original${popularMovieResults?.posterPath}"
            oldDate = popularMovieResults?.releaseDate
            rating = popularMovieResults?.voteAverage.toString()
            plot = popularMovieResults?.overview
            genres = popularMovieResults?.genreIds.toString()
        }

        if (popularTv != null) {
            link = "tv/${popularTv?.id.toString()}"
            title = popularTv?.title
            image = "https://image.tmdb.org/t/p/original${popularTv?.posterPath}"
            oldDate = popularTv?.firstAirDate
            rating = popularTv?.voteAverage.toString()
            plot = popularTv?.overview
            genres = popularTv?.genreIds.toString()
        }

        val sdf = SimpleDateFormat(oldDateFormat, Locale.getDefault())
        if (oldDate != null && oldDate.toString().isNotEmpty()) {
            val date = oldDate?.let { oldDate -> sdf.parse(oldDate) }
            sdf.applyPattern(newDateFormat)
            val releaseDate = date?.let { sdf.format(date) }
            tv_release_date.text = releaseDate
        }


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
            setBookmark()
        }

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setBookmark() {


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
            genres = genres.replace("[", "")
            genres = genres.replace("]", "")
            genres = genres.replace("28", "Action")
            genres = genres.replace("12", "Adventure")
            genres = genres.replace("16", "Animation")
            genres = genres.replace("35", "Comedy")
            genres = genres.replace("80", "Crime")
            genres = genres.replace("99", "Documentary")
            genres = genres.replace("18", "Drama")
            genres = genres.replace("10751", "Family")
            genres = genres.replace("10762", "Kids")
            genres = genres.replace("14", "Fantasy")
            genres = genres.replace("36", "History")
            genres = genres.replace("27", "Horror")
            genres = genres.replace("10402", "Music")
            genres = genres.replace("9648", "Mystery")
            genres = genres.replace("10749", "Romance")
            genres = genres.replace("878", "Sci-Fi")
            genres = genres.replace("10770", "TV Movie")
            genres = genres.replace("53", "Thriller")
            genres = genres.replace("10752", "War")
            genres = genres.replace("37", "Western")
            genres = genres.replace("10763", "News")
            genres = genres.replace("10764", "Reality")
            genres = genres.replace("10765", "War & Politics")
            genres = genres.replace("10766", "Soap")
            genres = genres.replace("10767", "Talk")
            genres = genres.replace("10768", "Talk")
            genres = genres.replace("10759", "Action & Adventure")
            genres = genres.replace(",", " \u2022")
        } else {
            genres = "Not Available"
        }
        return genres
    }
}