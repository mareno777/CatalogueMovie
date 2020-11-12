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
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.MOVE_ACTIVITY
import id.mareno.cataloguemovie.ui.fragment.HomeFragment.Companion.POPULAR_TV
import kotlinx.android.synthetic.main.movie_list_card.view.*

class PopularTvShowsAdapter :
    RecyclerView.Adapter<PopularTvShowsAdapter.PopularTvShowsViewHolder>() {
    private val popularTvShows = ArrayList<PopularTvResults>()

    fun setData(tvShow: List<PopularTvResults>?) {
        if (tvShow == null) return
        popularTvShows.clear()
        popularTvShows.addAll(tvShow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularTvShowsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return PopularTvShowsViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PopularTvShowsViewHolder,
        position: Int
    ) {
        holder.bind(popularTvShows[position])
    }

    override fun getItemCount(): Int = popularTvShows.size

    inner class PopularTvShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: PopularTvResults) {
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
                    val bundle = Bundle().apply {
                        putParcelable(POPULAR_TV, tvShow)
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