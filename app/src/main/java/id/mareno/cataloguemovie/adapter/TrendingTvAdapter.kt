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

class TrendingTvAdapter :
    ListAdapter<PosterResult, TrendingTvAdapter.TrendingTvViewHolder>(DifferentUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingTvAdapter.TrendingTvViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return TrendingTvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingTvAdapter.TrendingTvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TrendingTvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: PosterResult) {
            with(itemView) {
                tv_placeholder.text = tvShow.title
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${tvShow.posterPath}")
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
                        putExtra(EXTRA_ID, tvShow.id)
                        putExtra(EXTRA_TYPE, "tv")
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}