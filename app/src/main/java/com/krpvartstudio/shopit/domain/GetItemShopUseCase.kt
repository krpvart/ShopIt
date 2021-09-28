package com.krpvartstudio.shopit.domain

class GetItemShopUseCase(private val repositoryShopList: RepositoryShopList){

    fun getItemShop(idItemShop: Int):ItemShop{
        return repositoryShopList.getItemShop(idItemShop)
    }

}