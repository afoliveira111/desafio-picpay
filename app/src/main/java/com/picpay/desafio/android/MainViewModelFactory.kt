package com.picpay.desafio.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class MainViewModelFactory(private val getUsersUseCase: GetUsersUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getUsersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


//Essencialmente, essa fábrica (MainViewModelFactory) é utilizada para criar instâncias da MainViewModel
// com base em um caso específico, neste caso, a dependência getUsersUseCase.
// Isso é útil quando você precisa personalizar a criação de instâncias de ViewModel e fornecer dependências específicas durante a criação.
// A fábrica é utilizada geralmente em conjunto com a biblioteca Koin ou Dagger para injeção de dependência.