package com.leo.shared.network.repository

import com.leo.shared.core.base.BaseRepository
import com.leo.shared.core.result.Results
import com.leo.shared.network.ApiService
import com.leo.shared.network.repository.prefs.SharedPreferenceStorage
import javax.inject.Inject

class DataAmountRepository @Inject constructor(
    private val sharedPref: SharedPreferenceStorage,
    private val service: ApiService,
    private val baseRepository: BaseRepository
) {

    suspend fun callDataAmountAPI(resourceId: String, limit: Int): Results<String> =
        baseRepository.safeApiCall(
            call = {
                service.callDataAmountAPIAsync(resourceId, limit).await()
            },
            errorMessage = "Error occurred"
        )
}
