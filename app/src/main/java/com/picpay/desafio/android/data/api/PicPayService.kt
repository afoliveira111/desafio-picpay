package com.picpay.desafio.android.data.api


import com.picpay.desafio.android.data.models.User
import retrofit2.Response
import retrofit2.http.GET


interface PicPayService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}



//traocado para response!!!


//O uso de Response permite lidar com detalhes da resposta HTTP, como códigos de status,
// cabeçalhos etc. O retorno de List<User>

//O código apresenta uma interface chamada PicPayService que define um método de requisição HTTP
// usando a anotação @GET do Retrofit.
// O método getUsers é projetado para recuperar a lista de usuários da API,
// e a anotação @GET("users") especifica a parte final da URL para esse endpoint.