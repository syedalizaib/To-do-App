package com.joblogic.todoapp.ui.callList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joblogic.todoapp.entities.ItemToCall
import com.joblogic.todoapp.framework.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class CallListViewModel(private val repository: Repository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Call Fragment"
    }
    val loadingBarIsVisible = MutableLiveData<Boolean>()
    val callModelsList = MutableLiveData<ArrayList<ItemToCall>>()


    fun fetchCallList() {
        loadingBarIsVisible.value = true
        viewModelScope.launch {
            supervisorScope {
                val callListCall = async {
                    val callListResponse = repository.getRemoteCallList().data
                    if(callListResponse!=null) {
                        callModelsList.value = callListResponse as ArrayList<ItemToCall>
                    }
                    loadingBarIsVisible.value = false
                }
                callListCall.await()
            }
        }
    }
}