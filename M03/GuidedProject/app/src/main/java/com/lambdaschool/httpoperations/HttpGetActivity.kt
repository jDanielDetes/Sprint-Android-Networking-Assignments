package com.lambdaschool.httpoperations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lambdaschool.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpGetActivity : AppCompatActivity() {

    lateinit var  employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)

        // TODO: Create the api
        val gson= Gson()
        employeesService = Retrofit.Builder()
            .baseUrl(JsonPlaceHolderApi.Factory.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val type = intent.getStringExtra("get")
        if (type == "simple") {
            title = "GET - Simple Request"
            getEmployees()
        } else if (type == "path") {
            title = "GET - Path Parameter: EmployeeId - 1"
            getEmployees("1")
        }
        else{
            title = "GET - Query Parameter: Age - 55"
            getEmployeesForAge("55")
        }
    }

    private fun getEmployees(){
        // TODO: Write the call for getting all employees
        employeesService.getEmployees().enqueue(this)
    }

    private fun getEmployeesById(employeeId: String){
        // TODO: Write the call to get an employee by id
    }

    private fun getEmployeesForAge(age: String){
        // TODO: Write the call to get an employee by age
    }

}
