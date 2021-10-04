package com.krpvartstudio.shopit.presentation

import androidx.lifecycle.ViewModel
import com.krpvartstudio.shopit.data.RepositoryShopListImpl
import com.krpvartstudio.shopit.domain.*

class MainViewModel: ViewModel() {

    private val repositoryShopList = RepositoryShopListImpl


    private val getListItemShopUseCase = GetListItemShopUseCase(repositoryShopList)
    private val editItemShopUseCase = EditItemShopUseCase(repositoryShopList)
    private val deleteItemShopUseCase = DeleteItemShopUseCase(repositoryShopList)

    val shopList = getListItemShopUseCase.getListItemShop()



    fun changeEnableState(itemShop: ItemShop){
        val editItem = itemShop.copy(enabled = !itemShop.enabled)
        editItemShopUseCase.editItemShop(editItem)
    }

    fun deleteItemShop(itemShop: ItemShop){
        deleteItemShopUseCase.deleteItemShopList(itemShop)
    }



}