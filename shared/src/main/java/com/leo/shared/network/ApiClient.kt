package com.leo.shared.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiClient {

    /**
     * Get access token for other apis
     * Test Link: https://sit-gip.2c2p.com/GIPMobile_TestPage/Home/OAuthTokenRequest
     * */
    /*@FormUrlEncoded
    @POST("/oauth/token")
    fun getNewAccessToken(@Field("grant_type") grant_type: String): Call<AccessTokenRes>*/

    @GET("api/here/search")
    fun callDataAmount(
        @Query("id") resourceId: String,
        @Query("limit") limit: Int
    ): Deferred<Response<String>>
}