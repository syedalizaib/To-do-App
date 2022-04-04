package com.joblogic.todoapp.framework.repository

import androidx.lifecycle.LiveData
import com.joblogic.todoapp.entities.ItemToBuy
import com.joblogic.todoapp.entities.ItemToCall
import com.joblogic.todoapp.entities.ItemToSell
import com.joblogic.todoapp.framework.Result
import com.joblogic.todoapp.framework.remote.ApiDataSource
import com.joblogic.todoapp.framework.room.AppDatabase
import com.joblogic.todoapp.framework.room.dao.SellModelDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {

    @Inject
    lateinit var apiDataSource: ApiDataSource

    @Inject
    lateinit var sellingDao: SellModelDao
    lateinit var db: AppDatabase



    fun getSellingData(): LiveData<List<ItemToSell>> {
        return sellingDao.getAllSelling()
    }

    fun addSellingData(sellingData: List<ItemToSell>): List<Long> {
        return sellingDao.insertAll(sellingData)
    }


    fun wipeDb() {
        db.clearAllTables()
    }

    suspend fun getRemoteCallList(): Result<ArrayList<ItemToCall>> {
        return apiDataSource.fetchCallList()
    }

    suspend fun getRemoteBuyList(): Result<ArrayList<ItemToBuy>> {
        return apiDataSource.fetchBuyList()
    }

}
