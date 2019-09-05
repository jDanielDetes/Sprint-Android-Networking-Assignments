package com.example.httpoperations.Retrofit

import com.example.httpoperations.model.Employee
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface JsonPlaceHolderAPI {

    @GET("employees")
    fun getEmployees(): Call<List<Employee>>



    @GET("employees/{id}")
    fun getEmployeesById(@Path("id")employeeId: String)

    @GET("empoyees")
    fun getEmployeesByAge(employeeId: String) : Call<List<Employee>>


    class Factory {

        companion object{
            private const val BASE_URL ="https://demo8143297.mockable.io"
            fun create(): JsonPlaceHolderAPI {

                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                logger.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(JsonPlaceHolderAPI::class.java)
            }
        }
    }
}