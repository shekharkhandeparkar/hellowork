package com.leonet.eclub.ui.auth.login

import androidx.lifecycle.ViewModel
import com.leo.shared.core.di.FragmentScoped
import com.leo.shared.core.di.ViewModelKey
import com.leonet.eclub.ui.auth.signup.SignUpFragment
import com.leonet.eclub.ui.auth.signup.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Module where classes needed to create the [MainFragment] are defined.
 */
@Module
internal abstract class LoginModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeLoginFragment(): LoginFragment


    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginModel(viewModel: LoginViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeSignUpFragment(): SignUpFragment


    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    internal abstract fun bindSignUpModel(viewModel: SignUpViewModel): ViewModel
}
