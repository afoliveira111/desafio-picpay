package com.picpay.desafio.android


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface PicPayService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}



//traocado para response!!!



//O código apresenta uma interface chamada PicPayService que define um método de requisição HTTP usando a anotação @GET do Retrofit.
// O método getUsers é projetado para recuperar a lista de usuários da API,
// e a anotação @GET("users") especifica a parte final da URL para esse endpoint.