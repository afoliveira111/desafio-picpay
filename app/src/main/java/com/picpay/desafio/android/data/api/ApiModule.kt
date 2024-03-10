package com.picpay.desafio.android.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {

    val picPayService: PicPayService by lazy {
        retrofit.create(PicPayService::class.java)
    }
    private const val BASE_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"

    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()

            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}


//gson:
// Essa é a instância do Gson que será usada para converter os objetos JSON.
// usando o GsonBuilder para criar uma instância do Gson com as configurações padrão.

//retrofit:
//
//  Esta parte é onde você configura o Retrofit.
//  fornece a URL base, o cliente HTTP (okHttp), e o conversor JSON (gson).