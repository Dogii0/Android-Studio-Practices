package kr.ac.dankook.mobile.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val name = findViewById<TextView>(R.id.usern)
        val pass = findViewById<TextView>(R.id.passw)
        val btn = findViewById<Button>(R.id.btn)
        val result = findViewById<TextView>(R.id.result)
        val intentSub = intent

        val username = intentSub.getStringExtra("username")
        val password = intentSub.getStringExtra("password")
        val case = intentSub.getIntExtra("case", 0)

        name.setText(username)
        pass.setText(password)

        if(case==1){
            result.setText("New user logged in")
        }else if(case ==2){
            result.setText("Invalid username")
        }else if(case ==3){
            result.setText("Invalid password")
        }else if(case ==4){
            result.setText("User logged in")
        }

        btn.setOnClickListener {
//            val outIntent = Intent(this,MainActivity::class.java)

            finish()
        }
    }
}