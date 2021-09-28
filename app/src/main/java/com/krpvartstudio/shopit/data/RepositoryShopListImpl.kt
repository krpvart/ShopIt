package com.krpvartstudio.shopit.data

import android.content.ClipData
import com.krpvartstudio.shopit.domain.ItemShop
import com.krpvartstudio.shopit.domain.RepositoryShopList

object RepositoryShopListImpl: RepositoryShopList {

    private val shopList = mutableListOf<ItemShop>()
    private var idAutoInc = 0

    override fun addItemShop(itemShop: ItemShop) {
        if (itemShop.id == ItemShop.UNDEFINED_ID) {
            itemShop.id = idAutoInc++
        }
        shopList.add(itemShop)
    }

    override fun deleteItemShop(itemShop: ItemShop) {
       shopList.remove(itemShop)
    }

    override fun editItemShop(itemShop: ItemShop) {
        val oldItem = getItemShop(itemShop.id)
        deleteItemShop(oldItem)
        addItemShop(itemShop)
    }

    override fun getItemShop(idItemShop: Int): ItemShop {
        return shopList.find { it.id == idItemShop } ?: throw RuntimeException("Element with $idItemShop not found")
    }

    override fun getListItemShop(): List<ItemShop> {
        return shopList.toList()
    }
}