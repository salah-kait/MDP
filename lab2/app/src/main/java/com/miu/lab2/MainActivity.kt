package com.miu.lab2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val foodlist = arrayListOf( "Hamburger","Pizza","Mexican","American", "Chinese");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun decideFood(view: View) {
        val randomElement = foodlist.random();
        foodName.text = Editable.Factory.getInstance().newEditable(randomElement) ;

    }

    fun addFood(view: View) {
        val newFood =editTextTextPersonName.text.toString();
        if(newFood.trim() !=""){
            foodlist.add(newFood)
        }

    }
}