package id.mareno.cataloguemovie.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
import kotlinx.android.synthetic.main.coming_soon_list.view.*

class ComingSoonAdapter(private val activity: Activity) :
    RecyclerView.Adapter<ComingSoonAdapter.ComingSoonViewHolder>() {
    private val movieList = ArrayList<ComingSoonMovieResults>()

    fun setData(movie: List<ComingSoonMovieResults>?) {
        if (movie == null) return
        movieList.clear()
        movieList.addAll(movie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.coming_soon_list, parent, false)
        return ComingSoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComingSoonViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class ComingSoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: ComingSoonMovieResults) {
            with(itemView) {
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${movie.backdropPath}")
                    .placeholder(R.color.notBlack)
                    .error(R.color.notBlack)
                    .into(backdrop_image)

                tv_title.text = movie.title
                tv_plot.text = movie.overview
                tv_genres.text = formatedGenres(movie.genreIds.toString())

                btn_share.setOnClickListener {
                    val mimeType = "text/plain"
                    ShareCompat.IntentBuilder.from(activity).apply {
                        setType(mimeType)
                        setChooserTitle("Bagikan film ini sekarang.")
                        setText("https://www.themoviedb.org/movie/${movie.id}")
                        startChooser()
                    }
                }

                btn_favorite.setOnClickListener {
                    Snackbar.make(this, "Coming Soon", Snackbar.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun formatedGenres(rawGenres: String?): String {
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