package kr.ac.dankook.mobile.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var send = findViewById<Button>(R.id.Send)
        send.setOnClickListener {
            var to = findViewById<TextView>(R.id.To)
            var subject = findViewById<TextView>(R.id.Subject)
            var msg = findViewById<TextView>(R.id.Msg)
            var input1 = findViewById<EditText>(R.id.input)
            var input2 = findViewById<EditText>(R.id.input2)
            var input3 = findViewById<EditText>(R.id.input4)

            msg.setText("To:"+input3.getText() +"Subject :" + input2.getText() +"Message :" +input1.getText())
            input1.getText().clear();
            input2.getText().clear();
            input3.getText().clear();
        }
    }
}