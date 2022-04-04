package com.joblogic.todoapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joblogic.todoapp.framework.repository.Repository
import com.joblogic.todoapp.ui.buyList.BuyListViewModel
import com.joblogic.todoapp.ui.callList.CallListViewModel
import com.joblogic.todoapp.ui.home.HomeViewModel
import com.joblogic.todoapp.ui.sellList.SellViewModel
import com.joblogic.todoapp.ui.splash.SplashViewModel
import javax.inject.Inject

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {
    @Inject
    lateinit var repository: Repository

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            modelClass.isAssignableFrom(CallListViewModel::class.java) -> CallListViewModel(repository) as T
            modelClass.isAssignableFrom(BuyListViewModel::class.java) -> BuyListViewModel(repository) as T
            modelClass.isAssignableFrom(SellViewModel::class.java) -> SellViewModel(repository) as T
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
