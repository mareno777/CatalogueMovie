package id.mareno.cataloguemovie.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.PopularMoviesAdapter
import id.mareno.cataloguemovie.adapter.PopularTvShowsAdapter
import id.mareno.cataloguemovie.adapter.TrendingMovieAdapter
import id.mareno.cataloguemovie.adapter.TrendingTvAdapter
import id.mareno.cataloguemovie.presentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var trendingMovieAdapter: TrendingMovieAdapter
    private lateinit var trendingTvAdapter: TrendingTvAdapter
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter
    private lateinit var popularTvShowsAdapter: PopularTvShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trendingMovieAdapter = TrendingMovieAdapter()
        trendingTvAdapter = TrendingTvAdapter()
        popularMoviesAdapter = PopularMoviesAdapter()
        popularTvShowsAdapter = PopularTvShowsAdapter()

        rv_trending_movies_now.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = trendingMovieAdapter

        }

        rv_trending_tv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = trendingTvAdapter
        }

        rv_most_popular_movie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = popularMoviesAdapter
        }

        rv_most_popular_tv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularTvShowsAdapter
        }

        populateTrendingMovieNow()
        populateTrendingTvNow()
        populatePopularMovies()
        populatePopularTv()
    }

    private fun populateTrendingMovieNow() {
        startTrendingMovieShimmer(true)

        homeViewModel.getTrendingMovies().observe(viewLifecycleOwner) { movies ->
            if (movies.isEmpty()) return@observe
            startTrendingMovieShimmer(false)
            trendingMovieAdapter.submitList(movies)
        }

    }

    private fun populateTrendingTvNow() {
        startTrendingTvShimmer(true)

        homeViewModel.getTrendingTvs().observe(viewLifecycleOwner) { movies ->
            if (movies.isEmpty()) return@observe

            startTrendingTvShimmer(false)
            trendingTvAdapter.submitList(movies)
        }
    }

    private fun populatePopularMovies() {

        startPopularMovieShimmer(true)

        homeViewModel.getPopularMovies().observe(viewLifecycleOwner) { movies ->

            if (movies.isEmpty()) return@observe

            startPopularMovieShimmer(false)
            popularMoviesAdapter.submitList(movies)
        }
    }

    private fun populatePopularTv() {
        startPopularTvShimmer(true)

        homeViewModel.getPopularTvs().observe(viewLifecycleOwner) { movies ->
            val snackbar =
                Snackbar.make(
                    tv_most_popular,
                    "Something went wrong",
                    Snackbar.LENGTH_SHORT
                )

            snackbar.apply {
                setAction("RETRY") {
                    populatePopularTv()
                    populatePopularMovies()
                    populateTrendingTvNow()
                    populateTrendingMovieNow()
                }
                setActionTextColor(ContextCompat.getColor(requireContext(), R.color.colorRed))
            }
            if (movies.isEmpty()) {
                snackbar.show()
                return@observe
            }
            startPopularTvShimmer(false)
            popularTvShowsAdapter.submitList(movies)
        }
    }

    private fun startTrendingMovieShimmer(state: Boolean) {
        if (state) {
            shimmer_trending_movie.visibility = View.VISIBLE
            shimmer_trending_movie.startShimmer()
            rv_trending_movies_now.visibility = View.GONE
        } else {
            shimmer_trending_movie.stopShimmer()
            shimmer_trending_movie.visibility = View.GONE
            rv_trending_movies_now.visibility = View.VISIBLE
        }
    }

    private fun startTrendingTvShimmer(state: Boolean) {
        if (state) {
            shimmer_trending_tv.visibility = View.VISIBLE
            shimmer_trending_tv.startShimmer()
            rv_trending_tv.visibility = View.GONE
        } else {
            shimmer_trending_tv.stopShimmer()
            shimmer_trending_tv.visibility = View.GONE
            rv_trending_tv.visibility = View.VISIBLE
        }
    }

    private fun startPopularMovieShimmer(state: Boolean) {
        if (state) {
            shimmer_popular_movie.visibility = View.VISIBLE
            shimmer_popular_movie.startShimmer()
            rv_most_popular_movie.visibility = View.GONE
        } else {
            shimmer_popular_movie.stopShimmer()
            shimmer_popular_movie.visibility = View.GONE
            rv_most_popular_movie.visibility = View.VISIBLE
        }
    }

    private fun startPopularTvShimmer(state: Boolean) {
        if (state) {
            shimmer_popular_tv.visibility = View.VISIBLE
            shimmer_popular_tv.startShimmer()
            rv_most_popular_tv.visibility = View.GONE
        } else {
            shimmer_popular_tv.stopShimmer()
            shimmer_popular_tv.visibility = View.GONE
            rv_most_popular_tv.visibility = View.VISIBLE
        }
    }
}