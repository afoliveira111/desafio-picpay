package com.picpay.desafio.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding

class UserListAdapter : RecyclerView.Adapter<UserListItemViewHolder>() {

    var users = emptyList<User>()
        set(value) {
            val result = DiffUtil.calculateDiff(UserListDiffCallback(field, value))
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemUserBinding.inflate(inflater, parent, false)
        return UserListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}



//RecyclerView.Adapter<UserListItemViewHolder>():
//
//    Esta classe UserListAdapter herda de RecyclerView.Adapter
//    e é parametrizada pelo tipo UserListItemViewHolder,
//    que é a classe interna (ViewHolder) utilizada para exibir os itens da lista.