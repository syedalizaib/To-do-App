package com.joblogic.todoapp.entities

import com.google.gson.annotations.SerializedName


data class ItemToCall(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String
) {

    fun nameValue():String{
        return "Name : $name"
    }
    fun numberValue():String{
        return "Number : $number"
    }
}