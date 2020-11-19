package id.mareno.cataloguemovie.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.mareno.cataloguemovie.helper.di.RetrofitBuilder
import id.mareno.cataloguemovie.helper.di.RetrofitInterfaces
import id.mareno.cataloguemovie.model.json.PopularMovieModel
import id.mareno.cataloguemovie.model.json.PopularTvModel
import id.mareno.cataloguemovie.model.json.TrendingMovieModel
import id.mareno.cataloguemovie.model.json.TrendingTvModel
import id.mareno.cataloguemovie.model.responses.*
import id.mareno.cataloguemovie.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseHelper {

    private lateinit var trendingMoviesApi: RetrofitInterfaces.TrendingMoviesApi
    private lateinit var trendingtvApi: RetrofitInterfaces.TrendingTvApi
    private lateinit var popularMoviesApi: RetrofitInterfaces.PopularMoviesApi
    private lateinit var popularTvApi: RetrofitInterfaces.PopularTvApi
    private lateinit var detailMovieApi: RetrofitInterfaces.DetailMovie
    private lateinit var detailTvApi: RetrofitInterfaces.DetailTv

    fun loadTrendingMovies(): LiveData<List<TrendingMovieResults>> {
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
                    movieList.postValue(emptyList())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
            movieList.postValue(emptyList())
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
                    movieList.postValue(emptyList())
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
            movieList.postValue(emptyList())
        }
        return movieList
    }

    fun loadPopularMovies(): LiveData<List<PopularMovieResults>>? {
        EspressoIdlingResource.increment()
        val movieList = MutableLiveData<List<PopularMovieResults>>()
        popularMoviesApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.PopularMoviesApi::class.java)
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
                    movieList.postValue(emptyList())
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
            movieList.postValue(emptyList())
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
                    movieList.postValue(emptyList())
                }
            })
        } catch (e: Exception) {
            movieList.postValue(emptyList())
        }

        return movieList
    }

    fun loadDetailMovie(id: Int): LiveData<DetailMovieResults?> {
        val movieDetail = MutableLiveData<DetailMovieResults?>()
        detailMovieApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.DetailMovie::class.java)
        val movieDetailCall = detailMovieApi.getDetailMovie(id)
        try {
            movieDetailCall.enqueue(object : Callback<DetailMovieResults> {
                override fun onResponse(
                    call: Call<DetailMovieResults>,
                    response: Response<DetailMovieResults>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        movieDetail.postValue(jsonResponse)
                    }
                }

                override fun onFailure(call: Call<DetailMovieResults>, t: Throwable) {
                    movieDetail.postValue(null)
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
            movieDetail.postValue(null)
        }
        return movieDetail
    }

    fun loadDetailTv(id: Int): LiveData<DetailTvResults?> {
        val tvDetail = MutableLiveData<DetailTvResults?>()
        detailTvApi =
            RetrofitBuilder.getApiClient().create(RetrofitInterfaces.DetailTv::class.java)
        val tvDetailCall = detailTvApi.getDetailTv(id)
        try {
            tvDetailCall.enqueue(object : Callback<DetailTvResults> {
                override fun onResponse(
                    call: Call<DetailTvResults>,
                    response: Response<DetailTvResults>
                ) {
                    val jsonResponse = response.body()
                    if (jsonResponse != null) {
                        tvDetail.postValue(jsonResponse)
                    }
                }

                override fun onFailure(call: Call<DetailTvResults>, t: Throwable) {
                    tvDetail.postValue(null)
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
            tvDetail.postValue(null)
        }
        return tvDetail

    }
}