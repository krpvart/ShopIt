package com.krpvartstudio.shopit.presentation

import com.krpvartstudio.shopit.databinding.ItemShopListBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.krpvartstudio.shopit.R
import com.krpvartstudio.shopit.domain.ItemShop

class ListShopAdapter: RecyclerView.Adapter<ListShopAdapter.ListShopViewHolder>() {

    var listShop = listOf<ItemShop>()
    set(value){
        val callback = ShopListDiffCallback(listShop, value)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)
        field = value
    }

    var onShopItemLongClickListener: ((ItemShop) -> Unit)? = null
    var onShopItemClickListener: ((ItemShop) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemShopListBinding = ItemShopListBinding.inflate(layoutInflater, parent, false)
        return ListShopViewHolder(itemShopListBinding)
    }

    override fun onBindViewHolder(holder: ListShopViewHolder, position: Int) {
        val itemShop = listShop[position]
        holder.bindView(itemShop)
        holder.itemView.setOnLongClickListener{
            onShopItemLongClickListener?.invoke(itemShop)
            true
        }
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(itemShop)
        }

    }

    override fun getItemCount(): Int {
        return listShop.size
    }

    class ListShopViewHolder(private val itemShopListBinding: ItemShopListBinding)
        : RecyclerView.ViewHolder(itemShopListBinding.root){

        fun bindView(itemShop:ItemShop){
            itemShopListBinding.nameOfItemMtv.text = itemShop.name
            itemShopListBinding.countItemMtv.text = itemShop.count.toString()
            if (itemShop.enabled){itemShopListBinding.root.setCardBackgroundColor(
                ContextCompat.getColor(itemShopListBinding.root.context,R.color.purple_500))
            }else{
                itemShopListBinding.root.setCardBackgroundColor(
                    ContextCompat.getColor(itemShopListBinding.root.context,R.color.purple_200))
            }



        }
    }




}