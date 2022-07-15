package com.example.weighttrackingapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weighttrackingapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_splash
            )
        )

        val noBottomNavigationIds = listOf(R.id.navigation_splash)
        val noToolbarNavigationIds = listOf(R.id.navigation_splash)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val shouldShowBottomNavigation = noBottomNavigationIds.contains(destination.id).not()
            val shouldShowToolbar = noToolbarNavigationIds.contains(destination.id).not()
            binding.navView.isVisible = shouldShowBottomNavigation
            if(shouldShowToolbar){
                supportActionBar?.show()
            }else{
                supportActionBar?.hide()
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}