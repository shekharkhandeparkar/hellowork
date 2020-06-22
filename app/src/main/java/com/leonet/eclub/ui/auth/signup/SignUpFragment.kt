package com.leonet.eclub.ui.auth.signup

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.leonet.eclub.R
import com.leonet.eclub.base.BaseFragment
import com.leonet.eclub.databinding.FragmentLoginBinding
import com.leonet.eclub.databinding.FragmentSignUpBinding
import javax.inject.Inject

class SignUpFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private lateinit var binding:FragmentSignUpBinding

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false).apply {
            viewModel = viewModel
            lifecycleOwner = this@SignUpFragment
        }

        return binding.root
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }

}
