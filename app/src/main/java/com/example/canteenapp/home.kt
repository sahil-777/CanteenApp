package com.example.canteenapp

// package com.google.firebase.quickstart.auth.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.util.*
import com.google.firebase.database.*

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.Intent
import android.view.View
import com.example.canteenapp.adapter.MyItemAdapter
import com.example.canteenapp.listener.ItemLoadListener
import com.example.canteenapp.model.ItemModel
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity(), ItemLoadListener {
    private lateinit var auth: FirebaseAuth
    private  lateinit var itemLoadListener: ItemLoadListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        auth = Firebase.auth

        init()
        loadItemFromFirebase()

    }

    private fun loadItemFromFirebase(){
        val itemModels : MutableList<ItemModel> = ArrayList()
        FirebaseDatabase.getInstance().getReference("Admin/availableItems")
            .addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        for(itemSnapshot in snapshot.children){
                            val itemModel = itemSnapshot.getValue(ItemModel::class.java)
                            itemModel!!.key = itemSnapshot.key
                            itemModels.add(itemModel)
                        }
                        itemLoadListener.onItemLoadSuccess(itemModels)
                    }
                    else{
                       itemLoadListener.onItemLoadFailed("Item does not exist")
                    }
                }
            })
    }

    private fun init(){
        itemLoadListener = this
    }

    override fun onItemLoadSuccess(itemModelList: List<ItemModel>?) {
        var adapter = MyItemAdapter(this,itemModelList!!)
        recycler_item.adapter = adapter
    }

    override fun onItemLoadFailed(message: String?) {
        Snackbar.make(home,message!!,Snackbar.LENGTH_LONG).show()
    }

}
