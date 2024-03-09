package com.picpay.desafio.android


class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<User>? {
        return userRepository.getUsers()
    }
}


//Essa classe é um caso de uso (use case) que encapsula a lógica de negócios relacionada
// à obtenção de usuários.


//UserRepository. Uma interface que define métodos para interagir
// com a fonte de dados dos usuários, como um serviço web ou um banco de dados local!!!