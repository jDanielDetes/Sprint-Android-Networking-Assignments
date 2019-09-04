package com.lambdaschool.httpoperations.retrofit

import com.lambdaschool.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    // TODO: Create API for different endpoints

    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("employees/{id}")
    fun getEmployees(@PATH("id")employeeId: String)

    class Factory {

        companion object {
            private val BASE_URL = "https://demo8143297.mockable.io"
        }
    }
}
