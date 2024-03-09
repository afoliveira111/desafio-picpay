package com.picpay.desafio.android

import retrofit2.Call
import retrofit2.Response


interface UserRepository {
    suspend fun getUsers(): List<User>?
}