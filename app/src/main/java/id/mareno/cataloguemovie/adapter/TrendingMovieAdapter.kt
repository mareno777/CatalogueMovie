package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.MOVE_ACTIVITY
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.TRENDING_MOVIE
import kotlinx.android.synthetic.main.movie_list_card.view.*

class TrendingMovieAdapter : RecyclerView.Adapter<TrendingMovieAdapter.TrendingViewHolder>() {
    private val listMovies = ArrayList<TrendingMoviesEntity>()

    fun setData(movies: List<TrendingMoviesEntity>?) {
        if (movies == null) return
        listMovies.clear()
        listMovies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingMovieAdapter.TrendingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return TrendingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingMovieAdapter.TrendingViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = listMovies.size

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: TrendingMoviesEntity) {
            with(itemView) {
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                    .apply(RequestOptions()
                        .skipMemoryCache(true)
                        .dontAnimate()
                    )
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

                tv_placeholder.text = movie.title

                setOnClickListener {
                    val bundle = Bundle().apply {
                        putParcelable(TRENDING_MOVIE, movie)
                    }
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(MOVE_ACTIVITY, bundle)
                    }
                    context.startActivity(intent)
                }

            }
        }
    }
}