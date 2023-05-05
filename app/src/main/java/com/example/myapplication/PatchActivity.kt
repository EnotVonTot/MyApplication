package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patch)
    }

    fun next(view: View) {
        val intent = Intent(this@PatchActivity, SignIn::class.java)
        startActivity(intent)
        finish()
    }
}