package com.alessandro.magichelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alessandro.magichelper.scoreBoard.ScoreBoardFragment
import com.alessandro.magichelper.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private val searchFragment = SearchFragment()
    private val scoreBoardFragment = ScoreBoardFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, scoreBoardFragment)
                .commitNow()
        }
    }
}