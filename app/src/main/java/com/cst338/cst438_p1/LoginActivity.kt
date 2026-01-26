package com.cst338.cst438_p1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val user = findViewById<EditText>(R.id.UserName)
         val password = findViewById<EditText>(R.id.PasswordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupButton = findViewById<Button>(R.id.signUpButton)

        loginButton.setOnClickListener {
            val userName = user.text.toString()
            val passWord = password.text.toString()
            if (userName.isEmpty()||passWord.isEmpty()){
                Toast.makeText(this,"Please fill all fields", Toast.LENGTH_SHORT).show()
            }else{
                val temp = Intent(this, HomeActivity::class.java)
                startActivity(temp)
            }
        }
        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            //finish()
        }


    }
}