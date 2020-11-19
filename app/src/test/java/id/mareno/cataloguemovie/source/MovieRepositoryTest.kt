package id.mareno.cataloguemovie.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import id.mareno.cataloguemovie.source.remote.RemoteDataSource
import id.mareno.cataloguemovie.utils.DataDummy
import id.mareno.cataloguemovie.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val fakeCatalogueRepository = FakeCatalogueRepository(remote)

    private val trendingMovieResponses = DataDummy.generateRemoteTrendingMovies()
    private val trendingTvResponses = DataDummy.generateRemoteTrendingTvs()
    private val popularMovieResponses = DataDummy.generateRemotePopularMovies()
    private val popularTvResponses = DataDummy.generateRemotePopularTvs()

    @Test
    fun getAllTrendingMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTrendingMoviesCallback)
                .onAllMoviesReceived(trendingMovieResponses)
            null
        }.`when`(remote).getAllTrendingMovies(any())
        val movieEntities =
            LiveDataTestUtil.getValue(fakeCatalogueRepository.getAllTrendingMovies())
        verify(remote).getAllTrendingMovies(any())
        assertNotNull(movieEntities)
        assertEquals(trendingMovieResponses.size, movieEntities.size)
    }

    @Test
    fun getAllTrendingTvs() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTrendingTvsCallback)
                .onAllMoviesReceived(trendingTvResponses)
            null
        }.`when`(remote).getAllTrendingTvs(any())
        val movieEntities = LiveDataTestUtil.getValue(fakeCatalogueRepository.getAllTrendingTvs())
        verify(remote).getAllTrendingTvs(any())
        assertNotNull(movieEntities)
        assertEquals(trendingTvResponses.size, movieEntities.size)
    }

    @Test
    fun getAllPopularMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularMoviesCallback)
                .onAllMoviesReceived(popularMovieResponses)
            null
        }.`when`(remote).getAllPopularMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(fakeCatalogueRepository.getAllPopularMovies())
        verify(remote).getAllPopularMovies(any())
        assertNotNull(movieEntities)
        assertEquals(popularMovieResponses.size, movieEntities.size)
    }

    @Test
    fun getAllPopularTvs() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularTvsCallback)
                .onAllMoviesReceived(popularTvResponses)
            null
        }.`when`(remote).getAllPopularTvs(any())
        val movieEntities = LiveDataTestUtil.getValue(fakeCatalogueRepository.getAllPopularTvs())
        verify(remote).getAllPopularTvs(any())
        assertNotNull(movieEntities)
        assertEquals(popularTvResponses.size, movieEntities.size)
    }
}