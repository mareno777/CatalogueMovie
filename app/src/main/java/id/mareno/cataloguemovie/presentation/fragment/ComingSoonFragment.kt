package id.mareno.cataloguemovie.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.adapter.ComingSoonAdapter
import id.mareno.cataloguemovie.presentation.viewmodel.ComingSoonViewModel
import kotlinx.android.synthetic.main.fragment_coming_soon.*

@AndroidEntryPoint
class ComingSoonFragment : Fragment() {

    private val comingSoonViewModel: ComingSoonViewModel by viewModels()
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

        comingSoonAdapter = ComingSoonAdapter { url ->
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireContext()).apply {
                setType(mimeType)
                setChooserTitle("Bagikan film ini sekarang.")
                setText(url)
                startChooser()
            }
        }

        rv_coming_soon.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = comingSoonAdapter
        }

        comingSoonViewModel.getComingSoonMovies().observe(viewLifecycleOwner) { results ->
            comingSoonAdapter.setData(results)
        }
    }
}