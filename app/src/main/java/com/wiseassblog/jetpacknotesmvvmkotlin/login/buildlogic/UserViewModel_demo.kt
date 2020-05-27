package com.wiseassblog.jetpacknotesmvvmkotlin.login

import androidx.lifecycle.MutableLiveData
import com.wiseassblog.jetpacknotesmvvmkotlin.common.*
import com.wiseassblog.jetpacknotesmvvmkotlin.model.LoginResult
import com.wiseassblog.jetpacknotesmvvmkotlin.model.User
import com.wiseassblog.jetpacknotesmvvmkotlin.model.repository.IUserRepository
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class UserViewModel_demo(
    val repo: IUserRepository,
    uiContext: CoroutineContext
) : BaseViewModel<LoginEvent<LoginResult>>(uiContext) {

    private val userState = MutableLiveData<User>()

    internal val authAttempt = MutableLiveData<Unit>()
    internal val startAnimation = MutableLiveData<Unit>()

    internal val signInStatusText = MutableLiveData<String>()
    internal val authButtonText = MutableLiveData<String>()
    internal val satelliteDrawable = MutableLiveData<String>()

    private fun showErrorState() {
        signInStatusText.value = LOGIN_ERROR
        authButtonText.value = SIGN_IN
        satelliteDrawable.value = ANTENNA_EMPTY
    }


    private fun showSignedInState() {
        signInStatusText.value = SIGNED_IN
        authButtonText.value = SIGN_OUT
        satelliteDrawable.value = ANTENNA_FULL
    }

    private fun showSignedOutState() {
        signInStatusText.value = SIGNED_OUT
        authButtonText.value = SIGN_IN
        satelliteDrawable.value = ANTENNA_EMPTY
    }

    override fun handleEvent(event: LoginEvent<LoginResult>) {
        //Trigger loading screen first
        showLoadingState()
        when (event) {
            is LoginEvent.OnStart -> getUser()
            is LoginEvent.OnAuthButtonClick -> onAuthButtonClick()
            is LoginEvent.OnGoogleSignInResult -> onSignInResult(event.result)
        }
    }

    private fun showLoadingState() {
        signInStatusText.value = LOADING
        satelliteDrawable.value = ANTENNA_LOOP
        startAnimation.value = Unit
    }


    private fun getUser() = launch {
        val result = repo.getCurrentUser()
        when (result) {
            is Result.Value -> {
                userState.value = result.value
                if (result.value == null) showSignedOutState()
                else showSignedInState()
            }
            is Result.Error -> showErrorState()
        }
    }


    private fun onAuthButtonClick() {
        if (userState.value == null) authAttempt.value = Unit
        else signOutUser()
    }

    private fun onSignInResult(result: LoginResult) = launch {

    }

    private fun signOutUser() = launch {
        val result = repo.signOutCurrentUser()

        when (result) {
            is Result.Value -> {
                userState.value = null
                showSignedOutState()
            }
            is Result.Error -> showErrorState()
        }
    }


}