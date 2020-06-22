package com.leonet.eclub.ui.home

import androidx.lifecycle.ViewModel
import com.leo.shared.core.di.FragmentScoped
import com.leo.shared.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Module where classes needed to create the [MainFragment] are defined.
 */
@Module
internal abstract class HomeModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindLoginModel(viewModel: HomeViewModel): ViewModel
}
