package com.example.expensetracker.api;

import com.example.expensetracker.models.Person;
import retrofit2.http.GET;

interface UserApi {

    @GET("/person")
    suspend fun getUser() : List<Person>
}
