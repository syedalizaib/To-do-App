package com.joblogic.todoapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemToSell(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Int,

    @ColumnInfo(name = "quantity")
    val quantity: Int,
) {

    fun nameValue():String{
        return "Name : $name"
    }

    fun priceValue():String{
        return "Price : $price"
    }

    fun quantityValue():String{
        return "Quantity : $quantity"
    }
}