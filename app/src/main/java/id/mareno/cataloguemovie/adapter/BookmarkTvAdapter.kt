package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.entities.DetailTvEntity
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.movie_list_card.view.*

class BookmarkTvAdapter : RecyclerView.Adapter<BookmarkTvAdapter.BookmarkTvViewHolder>() {
    private val movieList = ArrayList<DetailTvEntity>()

    fun setData(movies: List<DetailTvEntity>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkTvViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return BookmarkTvViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkTvViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class BookmarkTvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: DetailTvEntity) {
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
                        putExtra(DetailActivity.EXTRA_ID, movie.id)
                        putExtra(DetailActivity.EXTRA_TYPE, "tv")
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}