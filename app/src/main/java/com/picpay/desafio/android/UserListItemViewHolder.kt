package com.picpay.desafio.android


import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.squareup.picasso.Picasso

class UserListItemViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        // Vincula o nome de usuário e username!!!
        binding.name.text = user.name
        binding.username.text = "@${user.username}"

        // Vincula a foto do usuário usando a biblioteca Picasso
        Picasso.get().load(user.img).into(binding.picture)

    }
}


//Essencialmente, a classe UserListItemViewHolder encapsula a lógica de vinculação dos dados de um objeto User aos elementos visuais
// em um item de usuário na RecyclerView. Isso é feito para cada item da lista, otimizando o desempenho ao reciclar views conforme necessário.