package com.picpay.desafio.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.models.CachedUser

@Database(entities = [CachedUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cachedUserDao(): CachedUserDao
}


//esse código define um banco de dados do Room chamado AppDatabase que possui uma tabela chamada CachedUser.
// O Room usa esse código para gerar automaticamente a implementação do banco de dados e
// fornecer acesso às operações de banco de dados por meio das interfaces DAO. Essa abordagem simplifica
// o código relacionado ao banco de dados e fornece uma camada de abstração para realizar operações no banco de dados local.