package kr.ac.dankook.mobile.myapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("kr.ac.dankook.example.SHARED_PREF", Context.MODE_PRIVATE);
        val editor = sharedPref.edit()
        val name = findViewById<EditText>(R.id.name)
        val pass = findViewById<EditText>(R.id.pass)
        val btn = findViewById<Button>(R.id.btn)
        val intentMain = Intent(this, SubActivity::class.java)

        val id = sharedPref.getInt("id", -1)
        var case = 0

        if(id==-1){
            case = 1
        }else{
            val username:String? = sharedPref.getString("Username", "unknown")
            val password:String? = sharedPref.getString("Password", "****")
            if(username!=name.getText().toString()){
                case =2
            }else if(password!=pass.getText().toString()){
                case =3
            }else{
                case=4
            }
        }


        btn.setOnClickListener {
            editor.putString("Username", name.getText().toString())
            editor.putString("Password", pass.getText().toString())
            editor.putInt("id", 1)
            editor.apply()

            Log.d("DKU Mobile", "New data has been entered")

            intentMain.putExtra("username", name.getText().toString())
            intentMain.putExtra("password", pass.getText().toString())
            intentMain.putExtra("case", case)

            name.getText().clear()
            pass.getText().clear()
            startActivity(intentMain)
        }
    }
}