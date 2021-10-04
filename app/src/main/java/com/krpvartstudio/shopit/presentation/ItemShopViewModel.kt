package com.krpvartstudio.shopit.presentation

import androidx.lifecycle.ViewModel
import com.krpvartstudio.shopit.data.RepositoryShopListImpl
import com.krpvartstudio.shopit.domain.AddItemShopUseCase
import com.krpvartstudio.shopit.domain.EditItemShopUseCase
import com.krpvartstudio.shopit.domain.GetItemShopUseCase
import com.krpvartstudio.shopit.domain.ItemShop
import java.lang.Exception

class ItemShopViewModel: ViewModel() {

    private val repositoryShopList = RepositoryShopListImpl


    private val addItemShopUseCase = AddItemShopUseCase(repositoryShopList)
    private val editItemShopUseCase = EditItemShopUseCase(repositoryShopList)
    private val getItemShopUseCase = GetItemShopUseCase(repositoryShopList)

    fun addItemShop(inputName: String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsvalid = validate(name,count)
        if (fieldsvalid) {
           val itemShop = ItemShop(name, count, true)
            addItemShopUseCase.addItemShopList(itemShop)
        }


    }

    fun editItemShop(itemShop: ItemShop){
        val editItem = itemShop.copy(enabled = !itemShop.enabled)
        editItemShopUseCase.editItemShop(editItem)
    }

    fun getItemShop(id: Int): ItemShop{
        return getItemShopUseCase.getItemShop(id)
    }


    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?:""
    }

    private fun parseCount(inputCount: String?): Int{
        return try {
            inputCount?.trim().toInt() ?: 0
        } catch (e:Exception) {
            0
        }
    }

    private fun validate(name: String, count:Int): Boolean{
        var result = true
        if(name.isBlank()){
            result = false
        }
        if(count <= 0){
            result = false
        }

    }
}