package com.krpvartstudio.shopit.domain

class AddItemShopUseCase (private val repositoryShopList: RepositoryShopList){

    fun addItemShopList(itemShop: ItemShop) {
        repositoryShopList.addItemShop(itemShop)
    }

}