package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.`interface`.RetrofitServices
import com.example.myapplication.model.data
import retrofit2.Call
import retrofit2.Response
import retrofit2.create


class PatchActivity : AppCompatActivity() {

    lateinit var rv22:RecyclerView
    lateinit var res:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patch)
        rv22=findViewById(R.id.recview1)
        val retrofit=myretrofit().getRetrofit()
        val api_ret=retrofit.create(RetrofitServices::class.java)
        val retr_call:Call<data> = api_ret.getImage()
        retr_call.enqueue(object:retrofit2.Callback<data>
        {
            override fun onResponse(call: Call<data>, responce: Response<data>) {
                if (responce.isSuccessful)
                {
                    rv22.adapter = responce.body()?.let { adapterv(applicationContext, it.data) }
                }
            }
            override fun onFailure(call: Call<data>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })

    }}