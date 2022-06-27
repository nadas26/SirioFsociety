package com.example.siriofsociety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.siriofsociety.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_page -> {
                    loadFragment(HomeFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favoris_page -> {
                    loadFragment(FavorisFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cart_page -> {
                    loadFragment(CartFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile_page -> {
                    loadFragment(ProfileFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search_page -> {
                    loadFragment(ExplorerFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }

        loadFragment(HomeFragment(this))
        //charger articleRepo
    }
    private fun loadFragment(fragment: Fragment){
        val repo = ArticleRepository()
        repo.updateData {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}