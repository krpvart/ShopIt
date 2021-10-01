package com.krpvartstudio.shopit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.krpvartstudio.shopit.R
import com.krpvartstudio.shopit.domain.ItemShop
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var listShopAdapter: ListShopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycleView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("ListTest", it.toString())
            listShopAdapter.listShop = it
        }
    }

    private fun setupRecycleView(){
        with(shoplist_rv){
            listShopAdapter = ListShopAdapter()
            adapter = listShopAdapter
        }
        setupLongClickListener()
        setupClickListener()
        setupSwipeListener()
    }

    private fun setupSwipeListener() {
        val swipeCallback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = listShopAdapter.listShop[viewHolder.adapterPosition]
                viewModel.deleteItemShop(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeCallback)
        itemTouchHelper.attachToRecyclerView(shoplist_rv)
    }

    private fun setupClickListener() {
        listShopAdapter.onShopItemClickListener = {
            Log.d("ItemInfo", "Selected item is ${it.name}")
        }
    }

    private fun setupLongClickListener() {
        listShopAdapter.onShopItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
    }

}