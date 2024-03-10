package com.picpay.desafio.android.repository

import com.picpay.desafio.android.data.models.User
import com.picpay.desafio.android.data.api.PicPayService


class UserRepositoryImpl(private val picPayService: PicPayService) : UserRepository {


    override suspend fun getUsers(): List<User>? {
        return try {
            val response = picPayService.getUsers()

            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}

//UserRepositoryImpl é uma classe que implementa a interface UserRepository.
// Ela tem uma dependência picPayService do tipo PicPayService, que é passada como um argumento para o construtor da classe.

//---------------->

//UserRepositoryImpl é uma implementação concreta de UserRepository que usa PicPayService para buscar
// uma lista de usuários de uma API. Ela retorna a lista de usuários se a solicitação for bem-sucedida
// e retorna null se a solicitação falhar ou se ocorrer uma exceção.