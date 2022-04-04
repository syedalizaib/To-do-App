package com.joblogic.todoapp.entities

data class ItemToBuy(
    val id: Int = 0,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int
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