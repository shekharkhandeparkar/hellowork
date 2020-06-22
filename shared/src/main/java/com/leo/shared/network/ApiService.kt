
package com.leo.shared.network

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ApiService
@Inject constructor(
    builder: Retrofit.Builder,
    private val sessions: Sessions,
    loggingInterceptor: HttpLoggingInterceptor
) {
    private val apiClient =
        builder.baseUrl("")
            .build()
            .create(ApiClient::class.java)

    fun callDataAmountAPIAsync(resourceId: String, limit: Int) = apiClient.callDataAmount(resourceId, limit)
}
