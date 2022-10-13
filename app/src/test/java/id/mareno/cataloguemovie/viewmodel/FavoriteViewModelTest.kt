package id.mareno.cataloguemovie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.source.CatalogueRepositoryImpl
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepositoryImpl

    @Mock
    private lateinit var movieObserver: Observer<PagedList<DetailMovieEntity>>

    @Mock
    private lateinit var tvObserver: Observer<PagedList<DetailTvEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<DetailMovieEntity>

    @Mock
    private lateinit var tvPagedList: PagedList<DetailTvEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogueRepository)
    }

    @Test
    fun retrieveBookmarkedMovies() {
        val dummyMovies = moviePagedList
        `when`(dummyMovies.size).thenReturn(6)
        val movies = MutableLiveData<PagedList<DetailMovieEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getBookmarkedMovies()).thenReturn(movies)
        val movieEntities = viewModel.retrieveBookmarkedMovies().value
        verify(catalogueRepository).getBookmarkedMovies()
        assertNotNull(movieEntities)
        assertEquals(6, movieEntities?.size)

        viewModel.retrieveBookmarkedMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun retrieveBookmarkedTvs() {
        val dummyMovies = tvPagedList
        `when`(dummyMovies.size).thenReturn(6)
        val movies = MutableLiveData<PagedList<DetailTvEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getBookmarkedTvs()).thenReturn(movies)
        val movieEntities = viewModel.retrieveBookmarkedTvs().value
        verify(catalogueRepository).getBookmarkedTvs()
        assertNotNull(movieEntities)
        assertEquals(6, movieEntities?.size)

        viewModel.retrieveBookmarkedTvs().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyMovies)
    }
}