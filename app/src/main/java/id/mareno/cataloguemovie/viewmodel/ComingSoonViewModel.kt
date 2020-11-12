package id.mareno.cataloguemovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.mareno.cataloguemovie.helper.di.RetrofitBuilder
import id.mareno.cataloguemovie.helper.di.RetrofitInterfaces
import id.mareno.cataloguemovie.model.entities.ComingSoonModel
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComingSoonViewModel : ViewModel() {
    private lateinit var comingSoonApi: RetrofitInterfaces.ComingSoonApi

    val movieResults = MutableLiveData<List<ComingSoonMovieResults>>()

    fun getMovie() {
        comingSoonApi = RetrofitBuilder.getApiClient().create(RetrofitInterfaces.ComingSoonApi::class.java)
        val trendingCall = comingSoonApi.getComingSoonMovies()
        try {

            trendingCall.enqueue(object : Callback<ComingSoonModel> {
                override fun onResponse(
                    call: Call<ComingSoonModel>,
                    response: Response<ComingSoonModel>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        val movie = jsonResponse.results
                        movieResults.postValue(movie)
                    }
                }

                override fun onFailure(call: Call<ComingSoonModel>, t: Throwable) {
                    Log.d("RETROFIT", t.message.toString())
                    movieResults.postValue(emptyList())
                }
            })


        } catch (e: Exception) {
            movieResults.postValue(emptyList())
        }
    }

    fun getMovieResults(): LiveData<List<ComingSoonMovieResults>> = movieResults
}