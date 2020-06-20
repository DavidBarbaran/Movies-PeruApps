package peruapps.movies.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import peruapps.movies.R

import peruapps.movies.databinding.ActivityAuthBinding
import peruapps.movies.ui.AuthState
import peruapps.movies.ui.ScreenState
import peruapps.movies.ui.dialog.MessageDialog
import peruapps.movies.ui.list.ListMovieActivity

class AuthActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by inject()
    private val binding: ActivityAuthBinding by inject {
        parametersOf(
            this,
            R.layout.activity_auth
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setViewModel()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setViewModel() {
        viewModel.apply {
            screenStateLiveData.observe(::getLifecycle, ::observerScreenState)
            authStateLiveData.observe(::getLifecycle, ::observerAuthState)
            showMessageErrorLiveData.observe(::getLifecycle, ::observerShowError)
        }
    }

    /** Observers **/

    private fun observerScreenState(screenState: ScreenState) {
        when (screenState) {
            ScreenState.Loading -> {
                Log.e("ScreenState", "Loading")
                binding.loadingView.visibility = View.VISIBLE
            }
            ScreenState.NotLoading -> {
                Log.e("ScreenState", "NotLoading")
                binding.loadingView.visibility = View.GONE
            }
            ScreenState.Success -> {
                Log.e("ScreenState", "Success")
                startActivity(Intent(this, ListMovieActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }

    private fun observerAuthState(authState: AuthState) {
        when (authState) {
            AuthState.EmailInvalid -> {
                binding.emailInputLayout.isErrorEnabled = true
                binding.emailInputLayout.error = "Enter a valid email"
            }
            AuthState.PasswordInvalid -> {
                binding.passwordInputLayout.isErrorEnabled = true
                binding.passwordInputLayout.error = "Enter a password"
            }
            AuthState.ErrorDisabled -> {
                binding.emailInputLayout.isErrorEnabled = false
                binding.passwordInputLayout.isErrorEnabled = false
            }
        }
    }

    private fun observerShowError(message: String) {
        MessageDialog.Builder(this).setMessage(message).show()
    }
}