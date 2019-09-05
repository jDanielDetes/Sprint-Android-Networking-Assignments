package com.example.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.Retrofit.JsonPlaceHolderAPI
import com.example.httpoperations.model.Employee
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class GETACTIVITY : AppCompatActivity() {

    lateinit var employeeService: JsonPlaceHolderAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getactivity)

        val type = intent.getStringExtra("get")
        if (type == "simple") {
            title = "GET - Simple Request"
            getEmployees()
        } else if (type == "path") {
            title = "GET - Path Parameter: EmployeeId - 1"

        }
        else{
            title = "GET - Query Parameter: Age - 55"

        }
    }

    fun getEmployees() {
        employeeService.getEmployees().enqueue(object: Callback<List<Employee>> {
            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                Toast.makeText(this@GETACTIVITY,"Failed", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<List<Employee>>,
                response: Response<List<Employee>>
            ) {
                response.body()?.let {
                    Toast.makeText(this@GETACTIVITY,it.toString(), Toast.LENGTH_SHORT).show()
                }
            }

    })
    }

    fun getEmployeesById(){


    }

    fun getEmployeesByAge(){


    }


    }



