package id.mareno.cataloguemovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.PopularMoviesAdapter
import id.mareno.cataloguemovie.adapter.PopularTvShowsAdapter
import id.mareno.cataloguemovie.adapter.TrendingMovieAdapter
import id.mareno.cataloguemovie.adapter.TrendingTvAdapter
import id.mareno.cataloguemovie.viewmodel.HomeViewModel
import id.mareno.cataloguemovie.viewmodel.ViewModelFactory
import id.mareno.cataloguemovie.vo.Status
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        const val MOVE_ACTIVITY = "move_activity"
        const val TRENDING_MOVIE = "trending_movie"
        const val TRENDING_TV = "trending_tv"
        const val POPULAR_MOVIE = "popular_movie"
        const val POPULAR_TV = "popular_tv"
        const val SEARCH_MOVIE = "search_movie"
    }

    private lateinit var homeViewModel: HomeViewModel

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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(viewLifecycleOwner, requireContext())
            homeViewModel = ViewModelProvider(requireActivity(), factory)[HomeViewModel::class.java]

            populateTrendingMovieNow()
            populateTrendingTvNow()
            populatePopularMovies()
            populatePopularTv()
        }
    }

    private fun populateTrendingMovieNow() {
        startTrendingMovieShimmer(true)

        homeViewModel.getTrendingMovies().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> startTrendingMovieShimmer(true)
                    Status.SUCCESS -> {
                        startTrendingMovieShimmer(false)
                        trendingMovieAdapter.setData(movies.data)
                        trendingMovieAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        Snackbar.make(
                            rv_trending_movies_now,
                            "Something went wrong",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })

    }

    private fun populateTrendingTvNow() {
        startTrendingTvShimmer(true)

        homeViewModel.getTrendingTvs().observe(viewLifecycleOwner, { movies ->
            startTrendingTvShimmer(false)
            trendingTvAdapter.setData(movies)
        })
    }

    private fun populatePopularMovies() {

        startPopularMovieShimmer(true)

        homeViewModel.getPopularMovies().observe(viewLifecycleOwner, { movies ->
            startPopularMovieShimmer(false)
            popularMoviesAdapter.setData(movies)
        })
    }

    private fun populatePopularTv() {
        startPopularTvShimmer(true)

        homeViewModel.getPopularTvs().observe(viewLifecycleOwner, { movies ->
            startPopularTvShimmer(false)
            popularTvShowsAdapter.setData(movies)
        })
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