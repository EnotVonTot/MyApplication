package com.example.myapplication.`interface`

import com.example.myapplication.model.data
import com.example.myapplication.model.data_movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("feelings")
    fun getImage():Call<data>
}