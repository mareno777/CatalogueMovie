package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.data.remote.dtos.PosterResult
import id.mareno.cataloguemovie.presentation.activity.DetailActivity
import id.mareno.cataloguemovie.presentation.activity.DetailActivity.Companion.EXTRA_ID
import id.mareno.cataloguemovie.presentation.activity.DetailActivity.Companion.EXTRA_TYPE
import kotlinx.android.synthetic.main.movie_list_card.view.*

class TrendingMovieAdapter :
    ListAdapter<PosterResult, TrendingMovieAdapter.TrendingViewHolder>(DifferentUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingMovieAdapter.TrendingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return TrendingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingMovieAdapter.TrendingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: PosterResult) {
            with(itemView) {
                Glide.with(itemView)
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

                tv_placeholder.text = movie.title

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