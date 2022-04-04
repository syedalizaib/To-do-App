package com.joblogic.todoapp.framework.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joblogic.todoapp.entities.ItemToSell

@Dao
interface SellModelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(categoryScore: List<ItemToSell>): List<Long>

    @Query("SELECT * FROM ItemToSell")
    fun getAllSelling(): LiveData<List<ItemToSell>>

}