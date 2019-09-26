package com.scodeid.mvvmscodeid.ui.auth


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.scodeid.mvvmscodeid.R
import com.scodeid.mvvmscodeid.databinding.ActivityLoginBinding
import com.scodeid.mvvmscodeid.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onStarted() {
        toast("OnStarted")
    }

    override fun onSuccess() {
        toast("OnSuccess")
    }

    override fun onFailure(messsage: String) {
        toast("OnFailure")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding  = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }
}
