package id.mareno.cataloguemovie.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.ComingSoonAdapter
import id.mareno.cataloguemovie.viewmodel.ComingSoonViewModel
import id.mareno.cataloguemovie.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_coming_soon.*

class ComingSoonFragment : Fragment() {

    private lateinit var comingSoonViewModel: ComingSoonViewModel
    private lateinit var comingSoonAdapter: ComingSoonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coming_soon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comingSoonAdapter = ComingSoonAdapter(requireActivity())

        rv_coming_soon.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = comingSoonAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {


            val factory = ViewModelFactory.getInstance(viewLifecycleOwner, requireContext())
            comingSoonViewModel = ViewModelProvider(
                requireActivity(),
                factory
            )[ComingSoonViewModel::class.java]

            comingSoonViewModel.getComingSoonMovies().observe(viewLifecycleOwner, { results ->
                comingSoonAdapter.setData(results)
            })
        }
    }
}