package com.leonet.eclub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.leo.shared.util.viewModelProvider
import com.leonet.eclub.base.BaseFragment
import com.leonet.eclub.databinding.FragmentHomeBinding

import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = viewModelProvider(viewModelFactory)
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeFragment
        }

        bindRecyclerData()

        homeViewModel.callDataAmountAPI()

        return binding.root
    }

    private fun bindRecyclerData() {
        binding.rvDataAmount.adapter =
            DataAmountAdapter(homeViewModel.dataAmountAPIObserver.value!!) {
            }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
