package kr.ac.dankook.mobile.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSay = findViewById<Button>(R.id.button1)
        btnSay.setOnClickListener {
            var textSay = findViewById<TextView>(R.id.text1)
            textSay.setText("My name is Dolgormaa")
        }
    }
}