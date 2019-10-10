package com.scodeid.mvvmscodeid.ui.auth
// [2]

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.scodeid.mvvmscodeid.R
import com.scodeid.mvvmscodeid.data.db.entities.User
import com.scodeid.mvvmscodeid.databinding.ActivityLoginBinding
import com.scodeid.mvvmscodeid.util.hide
import com.scodeid.mvvmscodeid.util.show
import com.scodeid.mvvmscodeid.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    companion object{
        val TAG_LOG = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val api = MyApi()
//        val db = AppDatabase(this)
//        val repository = UserRepository(api,db)

        val binding  = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        Log.d(TAG_LOG,"onStarted")
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        Log.d(TAG_LOG,"onSuccess")
        root_layout.snackbar("${user.name} is logged in")
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        root_layout.snackbar(message)
        Log.d(TAG_LOG,"onFailure")
        progress_bar.hide()
    }
}
