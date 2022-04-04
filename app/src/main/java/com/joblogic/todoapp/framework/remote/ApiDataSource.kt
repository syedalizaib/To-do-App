package com.joblogic.todoapp.framework.remote

import javax.inject.Inject


class ApiDataSource @Inject constructor() : SafeApiRequest() {


    private val TAG = ApiDataSource::class.java.simpleName

    @Inject
    lateinit var apiService: APIService

    suspend fun fetchCallList() = getResult { apiService.getCallList() }

    suspend fun fetchBuyList() = getResult { apiService.getBuyList() }

}

