package id.mareno.cataloguemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.BuildConfig
import id.mareno.cataloguemovie.helper.di.RetrofitBuilder
import id.mareno.cataloguemovie.helper.di.RetrofitInterfaces
import id.mareno.cataloguemovie.model.json.SearchMovieModel
import id.mareno.cataloguemovie.model.responses.SearchMovieResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private lateinit var searchMovieApi: RetrofitInterfaces.SearchMovieApi
    val movieResults = MutableLiveData<List<SearchMovieResults>>()

    fun getResultMovie(searchValue: String) {
        searchMovieApi = RetrofitBuilder.getApiClient().create(RetrofitInterfaces.SearchMovieApi::class.java)

        val searchCal = searchMovieApi.getSearchMovie(BuildConfig.API_KEY, searchValue)
        searchCal.enqueue(object : Callback<SearchMovieModel> {
            override fun onResponse(
                call: Call<SearchMovieModel>,
                response: Response<SearchMovieModel>
            ) {
                val jsonResponse = response.body()
                if (jsonResponse != null) {
                    movieResults.postValue(jsonResponse.results)
                }
            }

            override fun onFailure(call: Call<SearchMovieModel>, t: Throwable) {
                movieResults.postValue(emptyList())
            }
        })
    }

    fun setResultMovie(): LiveData<List<SearchMovieResults>> = movieResults
}