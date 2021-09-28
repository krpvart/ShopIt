package com.krpvartstudio.shopit.domain

import androidx.lifecycle.LiveData

class GetListItemShopUseCase(private val repositoryShopList: RepositoryShopList) {
    fun getListItemShop():LiveData<List<ItemShop>>{
       return repositoryShopList.getListItemShop()
    }
}