package com.krpvartstudio.shopit.domain

class EditItemShopUseCase(private val repositoryShopList: RepositoryShopList) {

    fun editItemShop(itemShop: ItemShop) {

        repositoryShopList.editItemShop(itemShop)

    }

}