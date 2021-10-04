package com.krpvartstudio.shopit.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.krpvartstudio.shopit.R
import com.krpvartstudio.shopit.domain.ItemShop
import kotlinx.android.synthetic.main.activity_item_shop.*
import java.lang.RuntimeException

class ItemShopActivity : AppCompatActivity() {

//    private lateinit var viewModel: ItemShopViewModel
//    private var screenMode = MOE_UNKNOWN
//    private var idItemShop = ItemShop.UNDEFINED_ID


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_shop)
//        parseIntent()
//        viewModel = ViewModelProvider(this)[ItemShopViewModel::class.java]
//        addTextChangeListeners()
//
//
//        when(screenMode){
//            EDIT_MODE -> launchEditMode()
//            ADD_MODE -> launchAddMode()
//        }
//
//        viewModel.errorInputCount.observe(this){
//            val message = if(it){
//                getString(R.string.error_message)
//            }else{
//                null
//            }
//            count_til.error = message
//        }
//
//        viewModel.errorInputName.observe(this){
//            val message = if(it){
//                getString(R.string.error_message)
//            }else{
//                null
//            }
//            name_til.error = message
//        }
//        viewModel.shouldCloseScreen.observe(this){
//            finish()
//        }
//
//    }
//
//    private fun addTextChangeListeners(){
//
//        name_tiet.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                viewModel.resetErrorInputName()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//
//            }
//        })
//    }
//
//    private fun launchEditMode(){
//        viewModel.getItemShop(idItemShop)
//        viewModel.itemShop.observe(this){
//            name_tiet.setText(it.name)
//            count_tiet.setText(it.count.toString())
//        }
//        save_btn.setOnClickListener{
//            viewModel.editItemShop(name_tiet.text?.toString(), count_tiet.text?.toString())
//        }
//    }
//
//    private fun launchAddMode(){
//        save_btn.setOnClickListener{
//            viewModel.addItemShop(name_tiet.text?.toString(), count_tiet.text?.toString())
//        }
//
//    }
//
//
//    private fun parseIntent(){
//        if(!intent.hasExtra(EXTRA_SCREEN_MODE)){
//            throw RuntimeException("Param screen mode is absent")
//        }
//        val mode=intent.getStringExtra(EXTRA_SCREEN_MODE)
//        if(mode!= ADD_MODE && mode!= EDIT_MODE){
//            throw RuntimeException("Unknown screen mode $mode")
//        }
//        screenMode = mode
//        if(screenMode== EDIT_MODE){
//            if(!intent.hasExtra(EXTRA_ID_ITEM_SHOP)){
//                throw RuntimeException("Param ID of ItemShop is absent")
//            }
//            idItemShop = intent.getIntExtra(EXTRA_ID_ITEM_SHOP, ItemShop.UNDEFINED_ID)
//
//        }
//    }
//
//
//
//
//    companion object{
//        private const val EXTRA_SCREEN_MODE = "extra_mode"
//        private const val EXTRA_ID_ITEM_SHOP = "extra_id_item_shop"
//        private const val ADD_MODE = "add_mode"
//        private const val EDIT_MODE = "edit_mode"
//        private const val MOE_UNKNOWN = ""
//
//
//        fun newIntentAddItemShop(context:Context): Intent {
//            val intent = Intent(context,ItemShopActivity::class.java)
//            intent.putExtra(EXTRA_SCREEN_MODE, ADD_MODE)
//            return intent
//        }
//
//        fun newIntentEditItemShop(context:Context, idShopItem: Int): Intent {
//            val intent = Intent(context,ItemShopActivity::class.java)
//            intent.putExtra(EXTRA_SCREEN_MODE, EDIT_MODE)
//            intent.putExtra(EXTRA_ID_ITEM_SHOP, idShopItem)
//            return intent
//        }
//     }
   }
}