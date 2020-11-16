package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import id.mareno.cataloguemovie.ui.activity.DetailActivity.Companion.EXTRA_ID
import id.mareno.cataloguemovie.ui.activity.DetailActivity.Companion.EXTRA_TYPE
import kotlinx.android.synthetic.main.movie_list_card.view.*

class SearchMovieAdapter : RecyclerView.Adapter<SearchMovieAdapter.SearchMovieHolder>() {
    private val movieList = ArrayList<SearchMovieResults>()

    fun setData(movies: List<SearchMovieResults>?) {
        if (movies != null) {
            movieList.clear()
            movieList.addAll(movies)
            Log.d(this::class.java.simpleName, movieList.size.toString())
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchMovieHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return SearchMovieHolder(view)
    }

    override fun onBindViewHolder(holder: SearchMovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class SearchMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: SearchMovieResults) {
            with(itemView) {
                tv_placeholder.text = movie.title

                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                    .into(object : CustomTarget<Drawable>() {
                        override fun onResourceReady(
                            resource: Drawable,
                            transition: Transition<in Drawable>?
                        ) {
                            image_poster.setImageDrawable(resource)
                            image_poster.visibility = View.VISIBLE
                        }

                        override fun onLoadCleared(placeholder: Drawable?) = Unit

                    })

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(EXTRA_ID, movie.id)
                        putExtra(EXTRA_TYPE, "movie")
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}