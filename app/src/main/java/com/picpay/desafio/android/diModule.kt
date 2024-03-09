package com.picpay.desafio.android


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}
//Este é um módulo de injeção de dependência (DI) usando a biblioteca Koin.
// A injeção de dependência é um padrão de design que permite que uma classe externalize
// suas dependências.
// Isso torna o código mais modular, testável e fácil de gerenciar.