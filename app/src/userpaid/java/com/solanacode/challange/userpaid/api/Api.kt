package com.solanacode.challangech5.userpaid.api

import com.solanacode.challangech5.api.ApiService
import com.solanacode.challangech5.userpaid.utils.Constant.Companion.BASE_MOVIE
import com.solanacode.challangech5.userpaid.utils.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
    val filmInstance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}