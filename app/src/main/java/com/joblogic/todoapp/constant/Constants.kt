package com.joblogic.todoapp.constant


import com.joblogic.todoapp.entities.ItemToSell

class Constants {
    companion object {
        const val BASE_URL = "https://my-json-server.typicode.com/imkhan334/demo-1/"
        const val APP_DB_NAME = "to_do_app_dp"

        fun getSellingData() = listOf(
            ItemToSell(1,"MacBook Pro 17", 30500,10),
            ItemToSell(2,"iPad", 20600,20),
            ItemToSell(3,"iPhone 13", 35000,30),
            ItemToSell(4,"Mac15", 42000,40),
        )
    }
}