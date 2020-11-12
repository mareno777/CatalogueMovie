package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.MOVE_ACTIVITY
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.TRENDING_TV
import kotlinx.android.synthetic.main.movie_list_card.view.*


class TrendingTvAdapter : RecyclerView.Adapter<TrendingTvAdapter.TrendingTvViewHolder>() {

    private val trendingTvShows = ArrayList<TrendingTvResults>()

    fun setData(movies: List<TrendingTvResults>?) {
        if (movies == null) return
        trendingTvShows.clear()
        trendingTvShows.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingTvAdapter.TrendingTvViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return TrendingTvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingTvAdapter.TrendingTvViewHolder, position: Int) {
        holder.bind(trendingTvShows[position])
    }

    override fun getItemCount(): Int = trendingTvShows.size


    inner class TrendingTvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: TrendingTvResults) {
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
                    val bundle = Bundle().apply {
                        putParcelable(TRENDING_TV, movie)
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