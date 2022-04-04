package com.joblogic.todoapp.ui.sellList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.entities.ItemToSell
import com.joblogic.todoapp.framework.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SellViewModel(private val repository: Repository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Sell Fragment"
    }

    val sellModelsList by lazy {
        repository.getSellingData()
    }

    fun insertSellingData(sellingData:List<ItemToSell>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSellingData(sellingData)
        }
    }
}