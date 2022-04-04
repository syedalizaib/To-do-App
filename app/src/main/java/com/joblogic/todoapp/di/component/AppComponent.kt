package com.joblogic.todoapp.di.component

import com.joblogic.todoapp.di.module.AppModule
import com.joblogic.todoapp.di.module.RetrofitModule
import com.joblogic.todoapp.ui.BaseFragment
import com.joblogic.todoapp.ui.MainActivity
import com.joblogic.todoapp.ui.callList.CallListAdapter
import com.joblogic.todoapp.ui.splash.SplashFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {
    fun inject(splashFragment: SplashFragment)
    fun inject(baseFragment: BaseFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(callListAdapter: CallListAdapter)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
        fun retrofitModule(retrofitModule: RetrofitModule): Builder
    }
}
