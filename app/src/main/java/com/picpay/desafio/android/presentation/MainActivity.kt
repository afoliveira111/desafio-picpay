package com.picpay.desafio.android.presentation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.usecase.GetUsersUseCase
import com.picpay.desafio.android.presentation.viewmodel.MainViewModel
import com.picpay.desafio.android.presentation.viewmodel.MainViewModelFactory
import com.picpay.desafio.android.presentation.adapter.UserListAdapter
import com.picpay.desafio.android.repository.UserRepositoryImpl
import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter
    private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    private val gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private val service: PicPayService by lazy {
        retrofit.create(PicPayService::class.java)
    }

    private val repository = UserRepositoryImpl(service)
    private val getUsersUseCase = GetUsersUseCase(repository)
    private val factory = MainViewModelFactory(getUsersUseCase)
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = binding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        mainViewModel.getUsers()

        val recyclerView = binding.recyclerView
        val progressBar = binding.userListProgressBar

        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        observeViewModel()

    }


    private fun observeViewModel() {
        mainViewModel.userList.observe(this) { userList ->
            // Atualize sua UI com a nova lista de usuários
            if (userList != null) {
                adapter.users = userList
            }
        }
    }
}


//MainActivity: É a atividade principal do seu aplicativo Android. Ela é responsável por exibir a lista de usuários na tela.
//Retrofit e OkHttpClient: São usados para fazer solicitações HTTP para a API e converter a resposta JSON em objetos Kotlin.
//PicPayService: É uma interface que define os endpoints da sua API.

//UserRepositoryImpl e GetUsersUseCase: São responsáveis pela lógica de busca dos usuários da API.
//MainViewModel: Contém a lógica de negócio e expõe os dados para a UI. Ele busca os usuários quando
// a atividade é criada e atualiza o LiveData quando os dados são recebidos.

//RecyclerView e UserListAdapter: São usados para exibir a lista de usuários na tela.
// ViewBinding torna o código mais claro e seguro, pois evita a possibilidade de
// NullPointerException e ClassCastException que podem ocorrer com o uso de findViewById().



