package com.leonet.eclub.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leo.shared.core.result.Event
import com.leo.shared.core.result.Results
import com.leo.shared.network.repository.DataAmountRepository
import com.leo.shared.network.repository.prefs.SharedPreferenceStorage
import com.leonet.eclub.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val context: Context,
    private val dataAmountRepository: DataAmountRepository,
    private val sharedPref: SharedPreferenceStorage
) : BaseViewModel() {

    private var resourceId = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
    private var limit = 10

    private val _dataAmountAPIObserver = MutableLiveData<List<String>>()
    val dataAmountAPIObserver: LiveData<List<String>> =
        _dataAmountAPIObserver

    fun callDataAmountAPI() {
        loading.postValue(Event(true))
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = dataAmountRepository.callDataAmountAPI(resourceId, limit)) {
                is Results.Success -> {
                    if (result.data != null) {
//                        saveUserCardsToDB(result.data.userCardList!!)
//                        _dataAmountAPIObserver.postValue(result.data)
//                        if (result.data.result.records.isNotEmpty()) {
//                            sharedPreferenceStorage.tempCardHashId =
//                                result.data.userCardList!![0].cardHashId
//                        }
                    }
                }

                is Results.Error -> {
                    failure.postValue(Event(result.exception.message.toString()))
                }
            }
            loading.postValue(Event(false))
        }
    }
}

