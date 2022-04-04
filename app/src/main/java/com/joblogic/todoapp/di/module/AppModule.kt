package com.joblogic.todoapp.di.module

import android.content.Context
import com.joblogic.todoapp.App
import com.joblogic.todoapp.framework.room.AppDatabase
import com.joblogic.todoapp.framework.room.dao.SellModelDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(context: App) {

    private val mContext = context

    @Singleton
    @Provides
    open fun provideContext(): Context {
        return mContext
    }


    @Singleton
    @Provides
    fun provideSellingDao(): SellModelDao {
        return provideRoom().sellModelDao()
    }

    @Singleton
    @Provides
    fun provideRoom(): AppDatabase {
        return AppDatabase.getInstance(mContext)
    }

}