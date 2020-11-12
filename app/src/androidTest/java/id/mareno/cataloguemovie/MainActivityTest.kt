package id.mareno.cataloguemovie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import id.mareno.cataloguemovie.ui.activity.MainActivity
import id.mareno.cataloguemovie.utils.DataDummy
import id.mareno.cataloguemovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    private val trendingMovies = DataDummy.generateRemoteTrendingMovies()
    private val trendingTvShows = DataDummy.generateRemoteTrendingTvs()
    private val popularMovies = DataDummy.generateRemotePopularMovies()
    private val popularTvShows = DataDummy.generateRemotePopularTvs()


    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    @Throws(Exception::class)
    fun loadMovies() {
        onView(withId(R.id.container)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rv_most_popular_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_most_popular_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(trendingMovies.size)
        )

        onView(withId(R.id.rv_most_popular_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_most_popular_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(popularMovies.size)
        )

        onView(withId(R.id.rv_most_popular_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_most_popular_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(popularTvShows.size)
        )

        onView(withId(R.id.rv_trending_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_trending_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(trendingTvShows.size)
        )
    }

    @Test
    @Throws(Exception::class)
    fun loadDetailMovie() {

        onView(withId(R.id.rv_trending_movies_now)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_back)).perform(click())

        onView(withId(R.id.rv_most_popular_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                6,
                click()
            )
        )
        onView(withId(R.id.scroll_view)).perform(ViewActions.swipeUp())
        onView(withId(R.id.btn_back)).perform(click())

        onView(withId(R.id.container)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rv_most_popular_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.btn_back)).perform(click())

        onView(withId(R.id.container)).perform(ViewActions.swipeUp())
        onView(withId(R.id.rv_trending_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                7,
                click()
            )
        )
        onView(withId(R.id.btn_back)).perform(click())
    }

    @Test
    @Throws(Exception::class)
    fun loadComingSoonMovies() {
        onView(withId(R.id.menu_coming_soon)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.rv_coming_soon)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    @Throws(Exception::class)
    fun checkAllFragments() {
        onView(withId(R.id.menu_search)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.menu_coming_soon)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.menu_favorite)).perform(click()).check(matches(isDisplayed()))
    }
}