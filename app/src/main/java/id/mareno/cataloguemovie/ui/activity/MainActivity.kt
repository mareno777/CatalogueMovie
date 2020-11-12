package id.mareno.cataloguemovie.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.ui.fragment.ComingSoonFragment
import id.mareno.cataloguemovie.ui.fragment.FavoriteFragment
import id.mareno.cataloguemovie.ui.fragment.HomeFragment
import id.mareno.cataloguemovie.ui.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment: Fragment = HomeFragment()
    private val searchFragment: Fragment = SearchFragment()
    private val comingSoonFragment: Fragment = ComingSoonFragment()
    private val favoriteFragment: Fragment = FavoriteFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction()
            .add(R.id.container, searchFragment, SearchFragment::class.java.simpleName)
            .hide(searchFragment).commit()
        fm.beginTransaction()
            .add(R.id.container, comingSoonFragment, ComingSoonFragment::class.java.simpleName)
            .hide(comingSoonFragment).commit()
        fm.beginTransaction()
            .add(R.id.container, favoriteFragment, FavoriteFragment::class.java.simpleName)
            .hide(favoriteFragment).commit()
        fm.beginTransaction().add(R.id.container, homeFragment, HomeFragment::class.java.simpleName)
            .commit()


        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {

                    fm.beginTransaction().hide(active).show(homeFragment).commit()
                    active = homeFragment

                    true
                }
                R.id.menu_search -> {

                    fm.beginTransaction().hide(active).show(searchFragment).commit()
                    active = searchFragment

                    true
                }
                R.id.menu_coming_soon -> {
                    fm.beginTransaction().hide(active).show(comingSoonFragment).commit()
                    active = comingSoonFragment
                    true
                }
                else -> {
                    fm.beginTransaction().hide(active).show(favoriteFragment).commit()
                    active = favoriteFragment
                    true
                }
            }
        }
    }
}