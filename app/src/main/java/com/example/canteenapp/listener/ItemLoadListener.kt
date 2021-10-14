package com.example.canteenapp.listener

import com.example.canteenapp.model.ItemModel

interface ItemLoadListener {
    fun onItemLoadSuccess(itemModelList:List<ItemModel>?)

    fun onItemLoadFailed(message:String?)
}