package com.example.expensetracker.repository

import com.example.expensetracker.api.UserApi
import com.example.expensetracker.models.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class expenseRepository @Inject constructor(private val userApi: UserApi){

    private val _userData = MutableStateFlow<List<Person>>(emptyList())

    val userData : StateFlow<List<Person>>
        get()=_userData
    suspend fun getData(){
        val response = userApi.getUser()
        _userData.emit(response)

    }
}