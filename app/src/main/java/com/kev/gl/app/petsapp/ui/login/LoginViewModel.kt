package com.kev.gl.app.petsapp.ui.login

import androidx.lifecycle.ViewModel
import com.kev.gl.app.petsapp.data.db.UserDB

/**
 * @author Kevin Villalobos
 */
class LoginViewModel : ViewModel() {

    fun doLogin(username: String, password: String): Boolean {
        return (UserDB.USER == username && password.isNotBlank())
    }

}