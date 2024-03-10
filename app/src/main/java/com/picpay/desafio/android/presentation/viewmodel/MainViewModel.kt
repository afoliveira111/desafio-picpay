package com.picpay.desafio.android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.usecase.GetUsersUseCase
import com.picpay.desafio.android.data.models.User
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _userList = MutableLiveData<List<User>?>()
    val userList: LiveData<List<User>?> get() = _userList

    fun getUsers() {
        viewModelScope.launch {
            try {
                val users = getUsersUseCase.invoke()
                _userList.value = users
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching users: ${e.message}")
            }
        }
    }
}


//Declaração da classe MainViewModel, que estende a classe ViewModel do Android.
//MainViewModel é responsável por gerenciar e fornecer dados relacionados à lista de usuários para a camada de visualização.

//Manter o estado da tela em mudanças de configuração:  o ViewModel para manter o estado da tela.
// O ViewModel sobrevive às mudanças de configuração e permite que os dados sejam preservados.


//LiveData é usado para permitir que a camada de visualização observe (observe)
// as mudanças na lista de usuários sem a capacidade de modificá-la diretamente.

//fun getUsers() {
//
//    Uma função  getUsers que inicia o processo de obtenção dos usuários.

//Essencialmente, a MainViewModel atua como um intermediário entre a camada de visualização
// (como uma Activity ou Fragment) e a lógica de negócios relacionada à obtenção de usuários (GetUsersUseCase).
// A lista de usuários é mantida como uma LiveData para que a camada de visualização possa observar automaticamente
// e reagir às atualizações sem precisar gerenciar explicitamente o ciclo de vida da ViewModel.