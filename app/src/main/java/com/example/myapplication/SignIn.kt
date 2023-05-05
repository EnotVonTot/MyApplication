package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignIn : AppCompatActivity() {
    lateinit var mail:EditText
    lateinit var pass:EditText

    val pattern=("[a-zA-Z0-9-\\._]{1,100}" +"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mail=findViewById(R.id.editText1)
        pass=findViewById(R.id.editText2)
    }

    fun MailValid(text:String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()      }

    fun next (view: View) {
        if(mail.text.toString().isNotEmpty())
        {
            if (MailValid(mail.text.toString())) {
                val intent = Intent(this@SignIn, PatchActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Ошибка при заполнении email", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            val alert= AlertDialog.Builder(this)
                .setTitle("Заполните логин или email")
                .setPositiveButton("OK", null)
                .create()
                .show()
        }
    }


    fun reg(view: View) {
        val intent = Intent( this@SignIn, RegAct::class.java)
        startActivity(intent)
        finish()
        finish()
    }
}