package com.joblogic.todoapp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.joblogic.todoapp.di.component.AppComponent
import com.joblogic.todoapp.di.component.DaggerAppComponent
import com.joblogic.todoapp.di.module.AppModule
import com.joblogic.todoapp.di.module.RetrofitModule

class App : Application() {

    companion object {

        private lateinit var mAppComponent: AppComponent
        private lateinit var instance: App

        fun getAppComponent(): AppComponent {
            return mAppComponent
        }

        fun getInstance() = instance
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}