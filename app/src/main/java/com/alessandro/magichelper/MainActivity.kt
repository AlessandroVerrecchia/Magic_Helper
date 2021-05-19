package com.alessandro.magichelper

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.navHostFragment).apply {
            graph.startDestination = R.id.scoreBoardFragment
        }
        bottomNavView.setupWithNavController(navController)
        handleBottomNavItemReselection(navController)
        addDestinationChangeListener(navController)
    }

    private fun handleBottomNavItemReselection(navController: NavController) {
        bottomNavView.setOnNavigationItemReselectedListener { menuItem ->
            navController.navigate(menuItem.itemId)
        }
    }

    private fun addDestinationChangeListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.MultiPlayerFragment -> {
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
                    bottomNavView.visibility = View.GONE
                }
                else -> {
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                    bottomNavView.visibility = View.VISIBLE
                }
            }
        }
    }


}