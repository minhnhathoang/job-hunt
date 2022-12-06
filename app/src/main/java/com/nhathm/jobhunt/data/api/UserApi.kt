package com.nhathm.jobhunt.data.api

import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("/?json=%7B%22key%22:%22value%22")
    fun login(): Response<String>
}