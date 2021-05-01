package com.alessandro.magichelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alessandro.magichelper.quickLinks.QuickLinksFragment
import com.alessandro.magichelper.scoreBoard.ScoreBoardFragment
import com.alessandro.magichelper.search.SearchFragment
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
    }

    private fun handleBottomNavItemReselection(navController: NavController) {
        bottomNavView.setOnNavigationItemReselectedListener { menuItem ->
            navController.navigate(menuItem.itemId)
        }
    }
}