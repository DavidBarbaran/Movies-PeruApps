package peruapps.movies.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import peruapps.movies.domain.auth.Auth
import peruapps.movies.domain.auth.AuthUseCase
import peruapps.movies.ui.ScreenState
import peruapps.movies.ui.AuthModel
import peruapps.movies.ui.AuthState
import peruapps.movies.ui.util.isNotValidEmail
import java.lang.Exception

class AuthViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _screenStateLiveData = MutableLiveData<ScreenState>()

    val screenStateLiveData: LiveData<ScreenState>
        get() = _screenStateLiveData

    private val _authStateLiveData = MutableLiveData<AuthState>()

    val authStateLiveData: LiveData<AuthState>
        get() = _authStateLiveData

    private val _showMessageErrorLiveData = MutableLiveData<String>()

    val showMessageErrorLiveData: LiveData<String>
        get() = _showMessageErrorLiveData

    var user = AuthModel()

    fun auth() {
        _authStateLiveData.value = AuthState.ErrorDisabled

        if (user.email.isNotValidEmail()) {
            _authStateLiveData.value = AuthState.EmailInvalid
            return
        }

        if (user.password.isBlank()) {
            _authStateLiveData.value = AuthState.PasswordInvalid
            return
        }

        _screenStateLiveData.value = ScreenState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                authUseCase.auth(
                    Auth(
                        user.email,
                        user.password
                    )
                )
                launch(Dispatchers.Main) {
                    _screenStateLiveData.value = ScreenState.Success
                }
            } catch (ex: Exception) {
                launch(Dispatchers.Main) {
                    _screenStateLiveData.value = ScreenState.NotLoading
                    _showMessageErrorLiveData.value = ex.message
                }
            }
        }
    }
}