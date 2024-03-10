package com.picpay.desafio.android.repository

import com.picpay.desafio.android.data.models.User


interface UserRepository {
    suspend fun getUsers(): List<User>?
}


//Em resumo, a interface UserRepository define um método assíncrono chamado

// getUsers que deve ser implementado por outras classes. Essa implementação

// deve recuperar a lista de usuários (ou possivelmente retornar null em caso de erro)
// e é comumente usada para interagir com fontes de dados, como uma API web, banco de dados local ou qualquer outro

// meio de armazenamento de dados relacionados aos usuários no contexto do aplicativo.