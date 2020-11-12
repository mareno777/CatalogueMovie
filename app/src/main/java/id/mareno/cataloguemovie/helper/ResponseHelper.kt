package id.mareno.cataloguemovie.helper

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.helper.di.RetrofitBuilder
import id.mareno.cataloguemovie.helper.di.RetrofitInterfaces
import id.mareno.cataloguemovie.model.entities.PopularMovieModel
import id.mareno.cataloguemovie.model.entities.PopularTvModel
import id.mareno.cataloguemovie.model.entities.TrendingMovieModel
import id.mareno.cataloguemovie.model.entities.TrendingTvModel
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseHelper {

    private lateinit var trendingMoviesApi: RetrofitInterfaces.TrendingMoviesApi
    private lateinit var trendingtvApi: RetrofitInterfaces.TrendingTvApi
    private lateinit var popularMoviesApi: RetrofitInterfaces.PopularMoviesApi
    private lateinit var popularTvApi: RetrofitInterfaces.PopularTvApi

    fun loadTrendingMovies(): LiveData<List<TrendingMovieResults>>? {
        EspressoIdlingResource.increment()
        val movieList = MutableLiveData<List<TrendingMovieResults>>()
        trendingMoviesApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.TrendingMoviesApi::class.java)
        val trendingCall = trendingMoviesApi.getTrendingMovies()

        try {
            trendingCall.enqueue(object : Callback<TrendingMovieModel> {
                override fun onResponse(
                    call: Call<TrendingMovieModel>,
                    response: Response<TrendingMovieModel>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        jsonResponse.results?.let { movieList.postValue(it) }
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TrendingMovieModel>, t: Throwable) {
                    Log.d("RETROFIT", t.message.toString())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList

    }

    fun loadTrendingTvs(): LiveData<List<TrendingTvResults>>? {
        EspressoIdlingResource.increment()
        val movieList = MutableLiveData<List<TrendingTvResults>>()
        trendingtvApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.TrendingTvApi::class.java)
        val trendingCall = trendingtvApi.getTrendingTvShows()
        try {
            trendingCall.enqueue(object : Callback<TrendingTvModel> {
                override fun onResponse(
                    call: Call<TrendingTvModel>,
                    response: Response<TrendingTvModel>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        jsonResponse.results.let { movieList.postValue(it) }
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TrendingTvModel>, t: Throwable) {
                    Log.d("RETROFIT", t.message.toString())
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    fun loadPopularMovies(): LiveData<List<PopularMovieResults>>? {
        EspressoIdlingResource.increment()
        val movieList = MutableLiveData<List<PopularMovieResults>>()
        popularMoviesApi = RetrofitBuilder.getApiClient().create(RetrofitInterfaces.PopularMoviesApi::class.java)
        val popularMoviesCall = popularMoviesApi.getPopularMovies()
        try {
            popularMoviesCall.enqueue(object : Callback<PopularMovieModel> {
                override fun onResponse(
                    call: Call<PopularMovieModel>,
                    response: Response<PopularMovieModel>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        jsonResponse.getPopularMovieResults()?.let { movieList.postValue(it) }
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<PopularMovieModel>, t: Throwable) {
                    Log.d("RETROFIT", t.message.toString())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    fun loadPopularTvs(): LiveData<List<PopularTvResults>>? {
        EspressoIdlingResource.increment()
        val movieList = MutableLiveData<List<PopularTvResults>>()
        popularTvApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.PopularTvApi::class.java)
        val popularTvCall = popularTvApi.getPopularTvShows()
        try {
            popularTvCall.enqueue(object : Callback<PopularTvModel> {
                override fun onResponse(
                    call: Call<PopularTvModel>,
                    response: Response<PopularTvModel>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        jsonResponse.results?.let { movieList.postValue(it) }
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<PopularTvModel>, t: Throwable) {
                    Log.d("RETROFIT", t.message.toString())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return movieList
    }
}