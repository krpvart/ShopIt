package com.krpvartstudio.shopit.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.krpvartstudio.shopit.R
import com.krpvartstudio.shopit.domain.ItemShop
import kotlinx.android.synthetic.main.fragment_item_shop.*
import java.lang.RuntimeException


class ItemShopFragment(
): Fragment() {
    private var screenMode: String = MOE_UNKNOWN
    private var idItemShop: Int = ItemShop.UNDEFINED_ID
    private lateinit var viewModel: ItemShopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ItemShopViewModel::class.java]
        addTextChangeListeners()


        when(screenMode){
            EDIT_MODE -> launchEditMode()
            ADD_MODE -> launchAddMode()
        }
    }

    private fun observeViewModel(){
        viewModel.errorInputCount.observe(viewLifecycleOwner){
            val message = if(it){
                getString(R.string.error_message)
            }else{
                null
            }
            count_til.error = message
        }

        viewModel.errorInputName.observe(viewLifecycleOwner){
            val message = if(it){
                getString(R.string.error_message)
            }else{
                null
            }
            name_til.error = message
        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            activity?.onBackPressed()
        }

    }





    private fun addTextChangeListeners(){
        name_tiet.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputName()
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun launchEditMode(){
        viewModel.getItemShop(idItemShop)
        viewModel.itemShop.observe(viewLifecycleOwner){
            name_tiet.setText(it.name)
            count_tiet.setText(it.count.toString())
        }
        save_btn.setOnClickListener{
            viewModel.editItemShop(name_tiet.text?.toString(), count_tiet.text?.toString())
        }
    }

    private fun launchAddMode(){
        save_btn.setOnClickListener{
            viewModel.addItemShop(name_tiet.text?.toString(), count_tiet.text?.toString())
        }

    }

    private fun parseParams() {
        val args = requireArguments()
        if(!args.containsKey(SCREEN_MODE)){
            throw RuntimeException("Param screen mode is absent")
        }
        val mode=args.getString(SCREEN_MODE)
        if(mode != ADD_MODE && mode != EDIT_MODE){
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if(screenMode == EDIT_MODE){
            if(!args.containsKey(ID_ITEM_SHOP)){
                throw RuntimeException("Param ID of ItemShop is absent")
            }
            idItemShop = args.getInt(ID_ITEM_SHOP, ItemShop.UNDEFINED_ID)

        }
    }

    companion object {
        private const val SCREEN_MODE = "extra_mode"
        private const val ID_ITEM_SHOP = "extra_id_item_shop"
        private const val ADD_MODE = "add_mode"
        private const val EDIT_MODE = "edit_mode"
        private const val MOE_UNKNOWN = ""


        fun newInstanceAddItem():ItemShopFragment{
            return ItemShopFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, ADD_MODE)
                }
            }
        }
        fun newInstanceEditItem(id:Int):ItemShopFragment{
            return ItemShopFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, EDIT_MODE)
                    putInt(ID_ITEM_SHOP,id)
                }
            }
        }

    }







}