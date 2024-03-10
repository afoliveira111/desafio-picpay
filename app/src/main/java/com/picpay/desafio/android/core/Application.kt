package com.picpay.desafio.android.core

import android.app.Application
import androidx.room.Room
import com.picpay.desafio.android.data.api.ApiModule.picPayService
import com.picpay.desafio.android.database.AppDatabase
import com.picpay.desafio.android.database.CachedUserDao
import com.picpay.desafio.android.di.appModule
import com.picpay.desafio.android.repository.UserRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()
    }

    val CachedUserDao: CachedUserDao by lazy {
        appDatabase.cachedUserDao()
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule)

}
        // Configuração do Room
        val appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()
        val cachedUserDao = appDatabase.cachedUserDao()
       // val userRepository = UserRepositoryImpl(picPayService, cachedUserDao)
    }
}


//inicialização do Koin (um framework de injeção de dependência) e criação do banco de dados Room

//Em resumo, esse código configura o Koin, cria e inicializa o banco de dados Room,
// e fornece instâncias relevantes para o uso em outras partes da aplicação, como o repositório.
// Ele mostra uma prática comum para configurar e inicializar dependências essenciais no início da execução da aplicação.