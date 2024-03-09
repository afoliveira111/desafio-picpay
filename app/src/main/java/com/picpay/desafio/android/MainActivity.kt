package com.picpay.desafio.android

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.list_item_user.progressBar
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter


    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = binding.root
        setContentView(view)


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


    // Tentativa de usar o binding!!!!!!!!


    // Restante do código permanece o mesmo
}
//   // private val url = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
//
//   // private val gson: Gson by lazy { GsonBuilder().create() }
//
//  //  private val okHttp: OkHttpClient by lazy {
// //       OkHttpClient.Builder()
//            .build()
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttp)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }

//    private val service: PicPayService by lazy {
//        retrofit.create(PicPayService::class.java)
//    }

//    override fun onResume() {
//        super.onResume()
//
//        recyclerView = findViewById(R.id.recyclerView)
//        progressBar = findViewById(R.id.user_list_progress_bar)
//
//        adapter = UserListAdapter()
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        progressBar.visibility = View.VISIBLE
//        viewModel.getUsers()
//        viewModel.userList.observe(this, Observer { users ->
//            progressBar.visibility = View.GONE
//            if (users != null) {
//                adapter.users = users
//            }
//
//            Toast.makeText(this@MainActivity, "Data fetched successfully", Toast.LENGTH_SHORT)
//                .show()
//        })
//    }
//    }


//private lateinit var progressBar: ProgressBar: declarando um ProgressBar,
// que será usado para indicar quando os dados estão sendo carregados.



