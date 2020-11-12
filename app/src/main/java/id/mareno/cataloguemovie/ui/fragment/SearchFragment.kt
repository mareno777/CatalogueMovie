package id.mareno.cataloguemovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.SearchMovieAdapter
import id.mareno.cataloguemovie.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val searchMovieAdapter = SearchMovieAdapter()

            rv_search_movie.apply {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = searchMovieAdapter
            }

            search_toolbar.setMenuItem(toolbar.menu.findItem(R.id.action_search))

            searchViewModel = ViewModelProvider(
                requireActivity(),
                ViewModelProvider.NewInstanceFactory()
            )[SearchViewModel::class.java]
            search_toolbar.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean = true

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query != null) {
                        searchViewModel.getResultMovie(query)
                    }
                    return true
                }

            })

            searchViewModel.setResultMovie().observe(viewLifecycleOwner, { result ->
                if (result.isEmpty()) {
                    rv_search_movie.visibility = View.GONE
                } else {
                    rv_search_movie.visibility = View.VISIBLE
                    searchMovieAdapter.setData(result)
                }
            })
        }
    }
}