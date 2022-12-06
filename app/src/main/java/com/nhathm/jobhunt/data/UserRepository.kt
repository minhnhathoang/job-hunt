package com.nhathm.jobhunt.data

import android.util.Log
import com.nhathm.jobhunt.data.api.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi) {

    suspend fun login() {
//        val response = userApi.login()
        Log.i("TEST_API", "Login test")
    }
}