package com.picpay.desafio.android.usecase

import com.picpay.desafio.android.data.models.User
import com.picpay.desafio.android.repository.UserRepository


class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<User> {
        val users = userRepository.getUsers() ?: throw UsersNotAvailableException("Lista de usuários nula.")
        return users
    }
}

class UsersNotAvailableException(message: String) : Exception(message)




//Essa classe é um caso de uso (use case) que encapsula a lógica de negócios relacionada
// à obtenção de usuários.


//UserRepository. Uma interface que define métodos para interagir
// com a fonte de dados dos usuários, como um serviço web ou um banco de dados local!!!