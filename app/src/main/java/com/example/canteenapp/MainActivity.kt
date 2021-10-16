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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.canteenapp.adapter.MyItemAdapter
import com.example.canteenapp.listener.ItemLoadListener
import com.example.canteenapp.model.ItemModel
import com.example.canteenapp.utils.SpaceItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.home.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemLoadListener {
    private lateinit var auth: FirebaseAuth
    private  lateinit var itemLoadListener: ItemLoadListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        auth = Firebase.auth

        //init()
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
                            //Toast.makeText(baseContext, "Item ${itemSnapshot.key}", Toast.LENGTH_SHORT).show()
                            itemModels.add(itemModel)
                        }
                        //itemLoadListener.onItemLoadSuccess(itemModels)
                        itemLoadListener.onItemLoadFailed("working")
                    }
                    else{
                        itemLoadListener.onItemLoadFailed("Item does not exist")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    itemLoadListener.onItemLoadFailed(error.message)
                }
            })
    }

    private fun init(){
        itemLoadListener = this

        val gridLayoutManager = GridLayoutManager(this,2)
        recycler_item.layoutManager = gridLayoutManager
        recycler_item.addItemDecoration(SpaceItemDecoration())
    }

    override fun onItemLoadSuccess(itemModelList: List<ItemModel>?) {
        var adapter = MyItemAdapter(this,itemModelList!!)
        recycler_item.adapter = adapter
    }

    override fun onItemLoadFailed(message: String?) {
        Snackbar.make(mainLayout,message!!,Snackbar.LENGTH_LONG).show()
    }

}
