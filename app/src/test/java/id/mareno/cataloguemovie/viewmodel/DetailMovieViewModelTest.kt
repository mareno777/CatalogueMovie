package id.mareno.cataloguemovie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.model.entities.detail.DetailMovieEntity
import id.mareno.cataloguemovie.model.entities.detail.DetailTvEntity
import id.mareno.cataloguemovie.source.CatalogueRepositoryImpl
import id.mareno.cataloguemovie.utils.DataDummy
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
class DetailMovieViewModelTest {
    private var movieId = 0
    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepositoryImpl

    @Mock
    private lateinit var movieObserver: Observer<DetailMovieEntity?>

    @Mock
    private lateinit var tvObserver: Observer<DetailTvEntity?>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(catalogueRepository)
    }

    @Test
    fun setSelectedMovieId() {
        movieId = 9
    }

    @Test
    fun getDetailMovieFromApi() {
        val dummyDetail = DataDummy.generateDetailMovie()
        val detail = MutableLiveData<DetailMovieEntity>()
        detail.value = dummyDetail

        `when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(detail)
        val detailMovie = viewModel.getDetailMovieFromApi().value
        verify(catalogueRepository).getDetailMovie(movieId)
        assertNotNull(detailMovie)
        assertEquals(dummyDetail.title, detailMovie?.title)

        viewModel.getDetailMovieFromApi().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyDetail)
    }

    @Test
    fun getDetailTv() {
        val dummyDetail = DataDummy.generateDetailTv()
        val detail = MutableLiveData<DetailTvEntity>()
        detail.value = dummyDetail

        `when`(catalogueRepository.getDetailTv(movieId)).thenReturn(detail)
        val detailMovie = viewModel.getDetailTv().value
        verify(catalogueRepository).getDetailTv(movieId)
        assertNotNull(detailMovie)
        assertEquals(dummyDetail.title, detailMovie?.title)

        viewModel.getDetailTv().observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyDetail)
    }
}