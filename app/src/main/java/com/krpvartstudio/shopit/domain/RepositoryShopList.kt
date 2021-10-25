package com.krpvartstudio.shopit.domain

import androidx.lifecycle.LiveData

interface
RepositoryShopList {

    fun addItemShop(itemShop: ItemShop)
    fun deleteItemShop(itemShop: ItemShop)
    fun editItemShop(itemShop: ItemShop)
    fun getItemShop(idItemShop: Int): ItemShop
    fun getListItemShop() : LiveData<List<ItemShop>>

}