package com.wiseassblog.jetpacknotesmvvmkotlin.login

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.content.Intent
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wiseassblog.jetpacknotesmvvmkotlin.R
import com.wiseassblog.jetpacknotesmvvmkotlin.common.startWithFade
import com.wiseassblog.jetpacknotesmvvmkotlin.login.buildlogic.LoginInjector
import com.wiseassblog.jetpacknotesmvvmkotlin.note.NoteActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.root_fragment_login

class LoginView_demo : Fragment() {

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.root.fragment_login, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(
            this,
            LoginInjector(requireActivity().application)
                .provideUserViewModelFactory()
        ).get(UserViewModel::class.java)
        (root_fragment_login.background as AnimationDrawable).startWithFade()
        setUpClickListeners()
        observeViewModels()
    }

    private fun observeViewModels() {
        viewModel.signInStatusText.observe(
            viewLifecycleOwner,
            Observer { text ->
                lbl_login_status_display.text = text
            }
        )

        viewModel.authButtonText.observe(
            viewLifecycleOwner,
            Observer {
                btn_auth_attempt.text = it
            }
        )
    }

    private fun setUpClickListeners() {
        btn_auth_attempt.setOnClickListener{ viewModel.handleEvent(LoginEvent.OnAuthButtonClick )}
        imb_toolbar_back.setOnClickListener{startListActivity()}

        requireActivity().addOnBackPressedCallback(viewLifecycleOwner,
            OnBackPressedCallback {
                startListActivity()
                true
            }
        )
    }

    private fun startListActivity() =requireActivity().startActivity(
        Intent (
            activity,
            NoteActivity::class.java
        )
    )
}