package id.mareno.cataloguemovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.BookmarkMovieAdapter
import id.mareno.cataloguemovie.adapter.BookmarkTvAdapter
import id.mareno.cataloguemovie.viewmodel.FavoriteViewModel
import id.mareno.cataloguemovie.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var bookmarkMovieAdapter: BookmarkMovieAdapter
    private lateinit var bookmarkTvAdapter: BookmarkTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookmarkMovieAdapter = BookmarkMovieAdapter()
        bookmarkTvAdapter = BookmarkTvAdapter()

        rv_favorite_movie.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bookmarkMovieAdapter
        }

        rv_favorite_tv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bookmarkTvAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(requireActivity(), factory)[FavoriteViewModel::class.java]
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.retrieveBookmarkedMovies().observe(viewLifecycleOwner) { movies ->
            if (movies == null || movies.isEmpty()) {
                rv_favorite_movie.visibility = View.GONE
                tv_empty_movie.visibility = View.VISIBLE
            } else {
                rv_favorite_movie.visibility = View.VISIBLE
                tv_empty_movie.visibility = View.GONE
                bookmarkMovieAdapter.submitList(movies)
            }
        }

        viewModel.retrieveBookmarkedTvs().observe(viewLifecycleOwner) { tvShows ->
            if (tvShows == null || tvShows.isEmpty()) {
                rv_favorite_tv.visibility = View.GONE
                tv_empty_tv.visibility = View.VISIBLE
            } else {
                tv_empty_tv.visibility = View.GONE
                rv_favorite_tv.visibility = View.VISIBLE
                bookmarkTvAdapter.submitList(tvShows)
            }
        }
    }

}