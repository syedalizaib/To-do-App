package com.joblogic.todoapp.framework.remote

import com.joblogic.todoapp.entities.ItemToBuy
import com.joblogic.todoapp.entities.ItemToCall
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("call")
    suspend fun getCallList(): Response<ArrayList<ItemToCall>>

    @GET("buy")
    suspend fun getBuyList(): Response<ArrayList<ItemToBuy>>
}