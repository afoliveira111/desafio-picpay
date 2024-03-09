package com.picpay.desafio.android

import java.io.Serializable

data class User(
    val img: String,
    val name: String,
    val id: Int,
    val username: String
) : Serializable


//    img: Uma string que representa a URL da imagem do usuário.
//    name: Uma string que contém o nome do usuário.
//    id: Um inteiro que representa o identificador único do usuário.
//    username: Uma string que contém o nome de usuário associado ao usuário.



//Serializable: Essa é uma interface marcadora em Java/Kotlin que indica que uma classe pode ser serializada.
// A serialização é o processo de converter um objeto em uma sequência de bytes, geralmente para armazenamento ou transmissão.
// Ao implementar a interface Serializable, a classe User pode ser usada em operações de serialização/deserialização.