package com.joblogic.todoapp.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joblogic.todoapp.framework.repository.Repository

class SplashViewModel(private val repository: Repository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is splash Fragment"
    }
    val text: LiveData<String> = _text
}