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
import id.mareno.cataloguemovie.model.entities.DetailMovieEntity
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import kotlinx.android.synthetic.main.movie_list_card.view.*

class BookmarkMovieAdapter : RecyclerView.Adapter<BookmarkMovieAdapter.BookmarkViewHolder>() {
    private val movieList = ArrayList<DetailMovieEntity>()

    fun setData(movies: List<DetailMovieEntity>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_card, parent, false)
        return BookmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    inner class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: DetailMovieEntity) {
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
                        putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}