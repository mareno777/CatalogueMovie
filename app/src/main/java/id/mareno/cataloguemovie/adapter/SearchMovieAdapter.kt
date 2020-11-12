package id.mareno.cataloguemovie.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import id.mareno.cataloguemovie.ui.activity.DetailActivity
import id.mareno.cataloguemovie.ui.fragment.HomeFragment
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
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                    .placeholder(R.color.notBlack)
                    .error(R.drawable.not_found)
                    .into(image_poster)

                tv_placeholder.text = movie.title

                setOnClickListener {
                    val bundle = Bundle().apply {
                        putParcelable(HomeFragment.SEARCH_MOVIE, movie)
                    }
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(HomeFragment.MOVE_ACTIVITY, bundle)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}