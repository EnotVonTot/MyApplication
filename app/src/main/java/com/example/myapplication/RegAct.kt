package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast


class RegAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
    }

    fun next(view: View) {
        val intent = Intent(this@RegAct, SignIn::class.java)
        startActivity(intent)
        finish()
    }

    fun regok(view: View) {
        val intent = Intent(this@RegAct, PatchActivity::class.java)
        Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()
        startActivity(intent)
        finish()
    }

}