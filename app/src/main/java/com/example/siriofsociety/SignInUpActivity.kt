package com.example.siriofsociety

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinup)

        var login = findViewById<Button>(R.id.BtnLoginPage)
        login.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent);
        }

        var signup = findViewById<TextView>(R.id.BtnRegisterButton)
        signup.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SignUpActivity::class.java)
            this.startActivity(intent);
        }
    }
}
