package com.picpay.desafio.android.di

import androidx.room.Room
import com.picpay.desafio.android.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "app-database"
        ).build()
    }

    single { get<AppDatabase>().cachedUserDao() }

   // single { UserRepositoryImpl(get<PicPayService>(), get()) }
}
//Este é um módulo de injeção de dependência (DI) usando a biblioteca Koin.
// A injeção de dependência é um padrão de design que permite que uma classe externalize
// suas dependências.
// Isso torna o código mais modular, testável e fácil de gerenciar.