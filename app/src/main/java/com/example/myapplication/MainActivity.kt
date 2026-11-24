package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var loginBtn: Button
    private lateinit var signupText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        inputEmail = findViewById<TextInputLayout>(R.id.loginemail)
        inputPassword = findViewById<TextInputLayout>(R.id.loginpassword)
        loginBtn = findViewById<Button>(R.id.loginBtn)
        signupText = findViewById<TextView>(R.id.signupBtn)

        loginBtn.setOnClickListener {
            val email = inputEmail.editText?.text.toString().trim()
            val password = inputPassword.editText?.text.toString().trim()

            if (email.isEmpty()){
                inputEmail.error = "Email is required"
            }else if(password.isEmpty()){
                inputPassword.error = "Password is required"
            }else if(password.length<=6){
                inputPassword.error = "Password should be greater than 6 characters"
            }else{
                inputEmail.error = null
                inputPassword.error = null
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
            }
        }
    }
}
