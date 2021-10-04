package com.krpvartstudio.shopit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krpvartstudio.shopit.data.RepositoryShopListImpl
import com.krpvartstudio.shopit.domain.AddItemShopUseCase
import com.krpvartstudio.shopit.domain.EditItemShopUseCase
import com.krpvartstudio.shopit.domain.GetItemShopUseCase
import com.krpvartstudio.shopit.domain.ItemShop
import java.lang.Exception

class ItemShopViewModel: ViewModel() {

    private val repositoryShopList = RepositoryShopListImpl

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _itemShop = MutableLiveData<ItemShop>()
    val itemShop: LiveData<ItemShop>
        get() = _itemShop

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

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
            finishWork()
        }


    }

    fun editItemShop(inputName: String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsvalid = validate(name,count)
        if (fieldsvalid) {
            _itemShop.value?.let {
                val item = it.copy(name = name, count = count)
                editItemShopUseCase.editItemShop(item)
                finishWork() }

        }
    }

    fun getItemShop(id: Int){
        val item = getItemShopUseCase.getItemShop(id)
        _itemShop.value = item
    }


    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?:""
    }

    private fun parseCount(inputCount: String?): Int{
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e:Exception) {
            0
        }
    }

    private fun validate(name: String, count:Int): Boolean{
        var result = true
        if(name.isBlank()){
            _errorInputName.value = true
            result = false
        }
        if(count <= 0){
            result = false
            _errorInputCount.value = true
        }
    return result
    }

    public fun resetErrorInputName() {
        _errorInputName.value =false
    }

    public fun resetErrorInputCount() {
        _errorInputCount.value =false
    }

    private fun finishWork(){
        _shouldCloseScreen.value = Unit
    }


}