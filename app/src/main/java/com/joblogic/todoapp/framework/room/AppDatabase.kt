package com.joblogic.todoapp.framework.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joblogic.todoapp.constant.Constants
import com.joblogic.todoapp.entities.ItemToSell
import com.joblogic.todoapp.framework.room.dao.SellModelDao

@Database(
    entities = [
        ItemToSell::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sellModelDao(): SellModelDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, Constants.APP_DB_NAME)
                .build()
        }
    }
}