package com.krpvartstudio.shopit.presentation

import androidx.recyclerview.widget.DiffUtil
import com.krpvartstudio.shopit.domain.ItemShop

class ItemShopDiff: DiffUtil.ItemCallback<ItemShop>() {
    override fun areItemsTheSame(oldItem: ItemShop, newItem: ItemShop): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemShop, newItem: ItemShop): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ItemShop, newItem: ItemShop): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}