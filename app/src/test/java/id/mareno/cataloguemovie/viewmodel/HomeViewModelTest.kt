package id.mareno.cataloguemovie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.model.entities.list.PopularMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.PopularTvsEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingMoviesEntity
import id.mareno.cataloguemovie.model.entities.list.TrendingTvsEntity
import id.mareno.cataloguemovie.source.CatalogueRepositoryImpl
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
    private lateinit var catalogueRepository: CatalogueRepositoryImpl

    @Mock
    private lateinit var observer: Observer<List<TrendingMoviesEntity>>

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(catalogueRepository)
    }

    @Test
    fun getTrendingMovies() {
        val dummyMovies = DataDummy.generateTrendingMovies()
        val movies = MutableLiveData<List<TrendingMoviesEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllTrendingMovies()).thenReturn(movies)
        val trendingMoviesEntities = homeViewModel.getTrendingMovies().value
        verify(catalogueRepository).getAllTrendingMovies()
        assertNotNull(trendingMoviesEntities)
        assertEquals(dummyMovies.size, trendingMoviesEntities?.size)

        homeViewModel.getTrendingMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTrendingTvShows() {
        val dummyMovies = DataDummy.generateTrendingTvs()
        val movies = MutableLiveData<List<TrendingTvsEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllTrendingTvs()).thenReturn(movies)
        val trendingTvEntities = homeViewModel.getTrendingTvs().value
        verify(catalogueRepository).getAllTrendingTvs()
        assertNotNull(trendingTvEntities)
        assertEquals(dummyMovies.size, trendingTvEntities?.size)
    }

    @Test
    fun getPopularMovies() {
        val dummyMovies = DataDummy.generatePopularMovies()
        val movies = MutableLiveData<List<PopularMoviesEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllPopularMovies()).thenReturn(movies)
        val popularMoviesEntities = homeViewModel.getPopularMovies().value
        verify(catalogueRepository).getAllPopularMovies()
        assertNotNull(popularMoviesEntities)
        assertEquals(dummyMovies.size, popularMoviesEntities?.size)
    }

    @Test
    fun getPopularTvShows() {
        val dummyMovies = DataDummy.generatePopularTvs()
        val movies = MutableLiveData<List<PopularTvsEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getAllPopularTvs()).thenReturn(movies)
        val popularTvEntities = homeViewModel.getPopularTvs().value
        verify(catalogueRepository).getAllPopularTvs()
        assertNotNull(popularTvEntities)
        assertEquals(dummyMovies.size, popularTvEntities?.size)
    }
}