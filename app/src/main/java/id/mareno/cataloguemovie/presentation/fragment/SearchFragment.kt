package id.mareno.cataloguemovie.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.SearchMovieAdapter
import id.mareno.cataloguemovie.presentation.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchMovieAdapter: SearchMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchMovieAdapter = SearchMovieAdapter()

        rv_search_movie.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            adapter = searchMovieAdapter
        }

        searchViewModel.setResultMovie().observe(viewLifecycleOwner) { result ->
            if (result.isEmpty()) {
                rv_search_movie.visibility = View.GONE
            } else {
                rv_search_movie.visibility = View.VISIBLE
                searchMovieAdapter.setData(result)
            }
        }
    }
}