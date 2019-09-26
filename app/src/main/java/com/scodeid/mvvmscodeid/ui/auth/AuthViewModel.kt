package com.scodeid.mvvmscodeid.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

/**
 * @author
 * Created by scode on 26,September,2019
 * Yogi Arif Widodo
 * www.dicoding.com/users/297307
 * www.github.com/yogithesymbian
 * SCODEID company,
 * Indonesia, East Borneo.
 * ==============================================================
Android Studio 3.4.2
Build #AI-183.6156.11.34.5692245, built on June 27, 2019
JRE: 1.8.0_152-release-1343-b16-5323222 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Linux 5.2.0-kali2-amd64
 * ==============================================================
 */

class AuthViewModel : ViewModel() {
    var email: String ?= null
    var pass: String ?= null

    var authListener : AuthListener? = null

    fun onLoginButtonClick(view: View){

        authListener?.onStarted()

        if (email.isNullOrEmpty() || pass.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return //return for empty
        }
        authListener?.onSuccess()
        // success
    }
}