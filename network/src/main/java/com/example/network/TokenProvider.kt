package com.example.network

fun interface TokenProvider {
    fun getToken(): String?
}