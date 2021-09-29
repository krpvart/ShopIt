package com.krpvartstudio.shopit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.krpvartstudio.shopit.R
import com.krpvartstudio.shopit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var listShopAdapter: ListShopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.shopList.observe(this){
            Log.d("ListTest", it.toString())



        }
    }

    private fun setupRecyclerView(){
        listShopAdapter = ListShopAdapter()


    }
}