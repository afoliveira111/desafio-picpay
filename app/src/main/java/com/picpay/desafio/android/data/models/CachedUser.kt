package com.picpay.desafio.android.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_users")
data class CachedUser(
    @PrimaryKey val id: Int,
    val img: String,
    val name: String,
    val username: String
)


//  A anotação @Entity indica que essa classe representa uma entidade que será armazenada no banco de dados Room.
//   O parâmetro tableName especifica o nome da tabela associada a essa entidade. Neste caso, a tabela é chamada "cached_users".



///Em resumo, essa classe CachedUser é uma representação da entidade que será armazenada no banco de dados Room.
// A anotação @Entity fornece informações sobre a tabela associada, e as propriedades da classe representam
// as colunas dessa tabela.
// A chave primária (id) é usada para identificar exclusivamente cada entrada na tabela.