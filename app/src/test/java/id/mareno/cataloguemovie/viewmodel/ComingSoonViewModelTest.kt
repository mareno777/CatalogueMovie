package id.mareno.cataloguemovie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.model.responses.ComingSoonMovieResults
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
class ComingSoonViewModelTest {

    private lateinit var viewModel: ComingSoonViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<ComingSoonMovieResults>>

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository


    @Before
    fun setUp() {
        viewModel = ComingSoonViewModel(catalogueRepository)
    }

    @Test
    fun getMovieResults() {
        val dummyMovies = DataDummy.generateComingSoon()
        val movies = MutableLiveData<List<ComingSoonMovieResults>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getComingSoon()).thenReturn(movies)
        val movieEntities = viewModel.getComingSoonMovies().value
        verify(catalogueRepository).getComingSoon()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size, movieEntities?.size)

        viewModel.getComingSoonMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}