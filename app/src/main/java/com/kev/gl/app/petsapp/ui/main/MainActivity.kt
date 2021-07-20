package com.kev.gl.app.petsapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.kev.gl.app.petsapp.R
import com.kev.gl.app.petsapp.databinding.ActivityMainBinding

/**
 * @author Kevin Villalobos
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init Binding
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Navigation Component
        setUpNavigation()
    }

    /**
     * Setup the Navigation Component
     */
    private fun setUpNavigation() {
        // Get Navigation host
        val host =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment

        // Get Navigation Controller
        mNavController = host.navController

        // Setup Root Level Fragments
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment
        ).build()

        // Setup Toolbar
        NavigationUI.setupWithNavController(
            mBinding.toolbar,
            mNavController,
            appBarConfiguration
        )

    }
}