package com.krpvartstudio.shopit.presentation

import com.krpvartstudio.shopit.databinding.ItemShopListBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.krpvartstudio.shopit.domain.ItemShop

class ListShopAdapter: RecyclerView.Adapter<ListShopAdapter.ListShopViewHolder>() {

    val listShop = listOf<ItemShop>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShopListBinding = ItemShopListBinding.inflate(layoutInflater, parent, false)
        return ListShopViewHolder(itemShopListBinding)
    }

    override fun onBindViewHolder(holder: ListShopViewHolder, position: Int) {
        holder.bindView(listShop[position])
    }

    override fun getItemCount(): Int {
        return listShop.size
    }

    class ListShopViewHolder(private val itemShopListBinding: ItemShopListBinding) : RecyclerView.ViewHolder(itemShopListBinding.root){

        fun bindView(itemShop:ItemShop){
            itemShopListBinding.nameOfItemMtv.text = itemShop.name
            itemShopListBinding.countItemMtv.text = itemShop.count.toString()
        }

    }


}