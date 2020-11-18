package id.mareno.cataloguemovie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.model.entities.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.responses.PopularMovieResults
import id.mareno.cataloguemovie.model.responses.PopularTvResults
import id.mareno.cataloguemovie.model.responses.TrendingMovieResults
import id.mareno.cataloguemovie.model.responses.TrendingTvResults
import id.mareno.cataloguemovie.source.CatalogueRepository
import id.mareno.cataloguemovie.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TrendingMovieResults>>

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(movieRepository)
    }

    @Test
    fun getTrendingMovies() {
        val dummyMovies = DataDummy.generateRemoteTrendingMovies()
        val movies = MutableLiveData<List<TrendingMoviesEntity>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllTrendingMovies()).thenReturn(movies)
        val trendingTvEntities = homeViewModel.getTrendingMovies().value
        verify(movieRepository).getAllTrendingMovies()
        assertNotNull(trendingTvEntities)
        assertEquals(dummyMovies.size, trendingTvEntities?.size)

        homeViewModel.getTrendingMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTrendingTvShows() {
        val dummyMovies = DataDummy.generateRemoteTrendingTvs()
        val movies = MutableLiveData<List<TrendingTvResults>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllTrendingTvs()).thenReturn(movies)
        val trendingTvEntities = homeViewModel.getTrendingTvs().value
        verify(movieRepository).getAllTrendingTvs()
        assertNotNull(trendingTvEntities)
        assertEquals(dummyMovies.size, trendingTvEntities?.size)
    }

    @Test
    fun getPopularMovies() {
        val dummyMovies = DataDummy.generateRemotePopularMovies()
        val movies = MutableLiveData<List<PopularMovieResults>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllPopularMovies()).thenReturn(movies)
        val popularMoviesEntities = homeViewModel.getPopularMovies().value
        verify(movieRepository).getAllPopularMovies()
        assertNotNull(popularMoviesEntities)
        assertEquals(dummyMovies.size, popularMoviesEntities?.size)
    }

    @Test
    fun getPopularTvShows() {
        val dummyMovies = DataDummy.generateRemotePopularTvs()
        val movies = MutableLiveData<List<PopularTvResults>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllPopularTvs()).thenReturn(movies)
        val popularTvEntities = homeViewModel.getPopularTvs().value
        verify(movieRepository).getAllPopularTvs()
        assertNotNull(popularTvEntities)
        assertEquals(dummyMovies.size, popularTvEntities?.size)
    }
}