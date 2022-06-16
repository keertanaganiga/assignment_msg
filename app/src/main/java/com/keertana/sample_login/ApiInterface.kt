package com.keertana.sample_login

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("entries")
    fun getData():Call<List<MyData>>
}