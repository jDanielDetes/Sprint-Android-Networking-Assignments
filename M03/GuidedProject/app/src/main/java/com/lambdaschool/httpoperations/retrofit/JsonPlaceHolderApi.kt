package com.lambdaschool.httpoperations.retrofit

import com.lambdaschool.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {
    // TODO: Create API for different endpoints

    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("employees/{id}")
    fun getEmployeesById(@Path("id")employeeId: String): Call<List<Employee>>


    @GET("employees")
    fun getEmployeesByAge(employeeId: String): Call<List<Employee>>

    class Factory {

        companion object {
             val BASE_URL = "https://demo8143297.mockable.io"
        }
    }
}
