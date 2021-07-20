package com.kev.gl.app.petsapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kev.gl.app.petsapp.R
import com.kev.gl.app.petsapp.databinding.ActivityLoginBinding
import com.kev.gl.app.petsapp.ui.main.MainActivity
import com.kev.gl.app.petsapp.utils.extensions.singleClick

/**
 * @author Kevin Villalobos
 */
class LoginActivity : AppCompatActivity() {

    private val mViewModel = LoginViewModel()
    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Update Views
        mBinding.apply {
            // Handle Click
            btnLogin.singleClick(block = ::setupLoginAction)
        }
    }

    private fun setupLoginAction() {
        // Reset The Error
        mBinding.txlUsername.error = null
        mBinding.txlPassword.error = null

        // Get the Values
        val username = mBinding.etUsername.text?.trim().toString()
        val password = mBinding.etPassword.text?.trim().toString()

        // Do the thing
        if (mViewModel.doLogin(username, password)) {
            // Navigate somewhere else
            goToHome()
        } else {
            val errorMessage = getString(R.string.login_error)
            mBinding.txlUsername.error = errorMessage
            mBinding.txlPassword.error = errorMessage
        }
    }

    private fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}