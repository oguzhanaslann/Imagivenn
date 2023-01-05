package com.example.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient(
    private val baseUrl: String,
    private val tokenProvider: TokenProvider
) {

    val client by lazy {
        getApiClient()
    }

    private fun getApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(
                getOkHttpClient()
            )
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                AuthenticationInterceptor(
                    tokenProvider = tokenProvider
                )
            )
            .build()
    }
}