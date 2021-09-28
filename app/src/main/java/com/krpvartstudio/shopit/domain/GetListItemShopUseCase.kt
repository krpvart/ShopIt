package com.krpvartstudio.shopit.domain

class GetListItemShopUseCase(private val repositoryShopList: RepositoryShopList) {
    fun getListItemShop():List<ItemShop>{
       return repositoryShopList.getListItemShop()
    }
}