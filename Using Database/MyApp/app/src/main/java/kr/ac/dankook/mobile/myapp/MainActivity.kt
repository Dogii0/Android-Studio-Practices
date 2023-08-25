package kr.ac.dankook.mobile.myapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val pass = findViewById<EditText>(R.id.pass)
        val btn = findViewById<Button>(R.id.login)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java, "User"
        ).allowMainThreadQueries().build()
        var i = 1
        btn.setOnClickListener {
            if(!db.userDao().isEmpty()) {
                i++
                Log.d("USERDB","Adding another data")
                val userd = User(i, name.getText().toString(), pass.getText().toString())
                db.userDao().insertAll(userd)
                
            } else {
                Log.d("USERDB","Adding first data")
                val userd = User(i, name.getText().toString(), pass.getText().toString())
                db.userDao().insertAll(userd)
            }
            name.getText().clear()
            pass.getText().clear()

            Log.d("DKU Mobile", "New data has been entered")
        }
    }
}
