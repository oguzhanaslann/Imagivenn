package com.example.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(
    private val tokenProvider: TokenProvider,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //Add Auth header and proceed the request
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader(
            HttpUtil.Authorization,
            HttpUtil.token(
                token = tokenProvider.getToken().orEmpty()
            )
        )
        return chain.proceed(builder.build())
    }
}

