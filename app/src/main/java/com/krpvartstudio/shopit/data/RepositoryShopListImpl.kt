package com.krpvartstudio.shopit.data

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.krpvartstudio.shopit.domain.ItemShop
import com.krpvartstudio.shopit.domain.RepositoryShopList
import kotlin.random.Random

object RepositoryShopListImpl: RepositoryShopList {

    private val shopListLiveData = MutableLiveData<List<ItemShop>>()
    private val shopList  = mutableListOf<ItemShop>()
    private var idAutoInc = 0


    init {
        for(i in 0 until 3) {
            val item = ItemShop("Name $i", i, Random.nextBoolean())
            addItemShop(item)
        }
    }

    override fun addItemShop(itemShop: ItemShop) {
        if (itemShop.id == ItemShop.UNDEFINED_ID) {
            itemShop.id = idAutoInc++
        }
        shopList.add(itemShop)
        updateList()
    }

    override fun deleteItemShop(itemShop: ItemShop) {
       shopList.remove(itemShop)
        updateList()
    }

    override fun editItemShop(itemShop: ItemShop) {
        val oldItem = getItemShop(itemShop.id)
        deleteItemShop(oldItem)
        addItemShop(itemShop)
    }

    override fun getItemShop(idItemShop: Int): ItemShop {
        return shopList.find { it.id == idItemShop } ?: throw RuntimeException("Element with $idItemShop not found")
    }

    override fun getListItemShop(): LiveData<List<ItemShop>> {
        return shopListLiveData
    }

    private fun updateList() {
        shopListLiveData.value = shopList.toList()

    }
}