package com.rfrost.navigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val navController = findNavController(R.id.nav_host)
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(nav_bottom, navController)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host).navigateUp()
}
