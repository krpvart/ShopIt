package com.krpvartstudio.shopit.domain

class DeleteItemShopUseCase(private val repositoryShopList: RepositoryShopList) {
    fun deleteItemShopList(itemShop: ItemShop) {
        repositoryShopList.deleteItemShop(itemShop)
    }

}