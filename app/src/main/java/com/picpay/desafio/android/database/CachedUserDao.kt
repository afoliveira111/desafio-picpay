package com.picpay.desafio.android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.data.models.CachedUser

@Dao
interface CachedUserDao {
    @Query("SELECT * FROM cached_users")
    suspend fun getCachedUsers(): List<CachedUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<CachedUser>)
}


//Esse código define um DAO (Data Access Object) para interagir com a tabela cached_users em um banco de dados Room


//este DAO fornece métodos para realizar operações básicas no banco de dados associado à entidade CachedUser.
// Ele permite a recuperação de todos os registros da tabela e a inserção de uma lista de registros,
// com a estratégia de substituição em caso de conflito.
// Essa estrutura é usada para acessar dados do banco de dados Room relacionados aos usuários armazenados localmente.