package com.krpvartstudio.shopit.domain

interface RepositoryShopList {

    fun addItemShop(itemShop: ItemShop)
    fun deleteItemShop(itemShop: ItemShop)
    fun editItemShop(itemShop: ItemShop)
    fun getItemShop(idItemShop: Int): ItemShop
    fun getListItemShop() : List<ItemShop>

}