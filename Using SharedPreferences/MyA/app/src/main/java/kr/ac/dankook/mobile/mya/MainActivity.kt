package kr.ac.dankook.mobile.mya

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("kr.ac.dankook.example.SHARED_PREF", Context.MODE_PRIVATE);
        val editor = sharedPref.edit()
        val name = findViewById<EditText>(R.id.name)
        val pass = findViewById<EditText>(R.id.pass)
        val btn = findViewById<Button>(R.id.login)

        val id = sharedPref.getInt("id", -1)
        if(id==-1){
            Log.d("DKU mobile", "No data")
        }else{
            val username:String? = sharedPref.getString("Username", "unknown")
            val password:String? = sharedPref.getString("Password", "****")
            name.setText(username)
            pass.setText(password)
        }

        btn.setOnClickListener {
            editor.putString("Username", name.getText().toString())
            editor.putString("Password", pass.getText().toString())
            editor.putInt("id", 1)
            editor.apply()

            name.getText().clear()
            pass.getText().clear()

            Log.d("DKU Mobile", "New data has been entered")
        }
    }
}