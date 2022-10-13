package id.mareno.cataloguemovie.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.hilt.android.AndroidEntryPoint
import id.mareno.cataloguemovie.R
import id.mareno.cataloguemovie.presentation.fragment.ComingSoonFragment
import id.mareno.cataloguemovie.presentation.fragment.FavoriteFragment
import id.mareno.cataloguemovie.presentation.fragment.HomeFragment
import id.mareno.cataloguemovie.presentation.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeFragment: Fragment = HomeFragment()
    private val searchFragment: Fragment = SearchFragment()
    private val comingSoonFragment: Fragment = ComingSoonFragment()
    private val favoriteFragment: Fragment = FavoriteFragment()
    private val fragmentManager: FragmentManager = supportFragmentManager
    private var active = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
            .add(R.id.container, searchFragment, SearchFragment::class.java.simpleName)
            .hide(searchFragment).commit()
        fragmentManager.beginTransaction()
            .add(R.id.container, comingSoonFragment, ComingSoonFragment::class.java.simpleName)
            .hide(comingSoonFragment).commit()
        fragmentManager.beginTransaction()
            .add(R.id.container, favoriteFragment, FavoriteFragment::class.java.simpleName)
            .hide(favoriteFragment).commit()
        fragmentManager.beginTransaction().add(R.id.container, homeFragment, HomeFragment::class.java.simpleName)
            .commit()


        bottom_navigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    fragmentManager.beginTransaction().hide(active).show(homeFragment).commit()
                    active = homeFragment
                    true
                }
                R.id.menu_search -> {
                    fragmentManager.beginTransaction().hide(active).show(searchFragment).commit()
                    active = searchFragment
                    true
                }
                R.id.menu_coming_soon -> {
                    fragmentManager.beginTransaction().hide(active).show(comingSoonFragment).commit()
                    active = comingSoonFragment
                    true
                }
                R.id.menu_favorite -> {
                    fragmentManager.beginTransaction().hide(active).show(favoriteFragment).commit()
                    active = favoriteFragment
                    true
                }
                else -> false
            }
        }
    }
}