package com.joblogic.todoapp.ui.buyList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.entities.ItemToBuy
import com.joblogic.todoapp.framework.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class BuyListViewModel(private val repository: Repository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Buy Fragment"
    }
    val loadingBarIsVisible = MutableLiveData<Boolean>()
    val buyModelsList = MutableLiveData<ArrayList<ItemToBuy>>()


    fun fetchBuyList() {
        loadingBarIsVisible.value = true
        viewModelScope.launch {
            supervisorScope {
                val buyListCall = async {
                    val buyListResponse = repository.getRemoteBuyList().data
                    if(buyListResponse!=null) {
                        buyModelsList.value = buyListResponse as ArrayList<ItemToBuy>
                    }
                    loadingBarIsVisible.value = false
                }
                buyListCall.await()
            }
        }
    }
}