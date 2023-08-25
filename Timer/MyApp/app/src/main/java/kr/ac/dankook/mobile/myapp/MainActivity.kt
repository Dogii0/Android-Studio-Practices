package kr.ac.dankook.mobile.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
var started = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id. text)
        val btnStart = findViewById<Button>(R.id. start)
        val btnStop = findViewById<Button>(R.id. stop)

        val myHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if(msg.what == 1){
                    val sec = msg.arg1%60
                    val min = msg.arg1/60
                    if(min<10){
                        if(sec<10){
                            text.setText("0$min:0$sec")
                        }else{
                            text.setText("0$min:$sec")
                        }
                    }else{
                        if(sec<10){
                            text.setText("$min:0$sec")
                        }else{
                            text.setText("$min:$sec")
                        }
                    }
                    Log.d("Timer", "$min minute(s) and $sec second(s)")
                }
            }
        }


        Thread {
            var i=0
            while(true) {
                Thread.sleep(1000)
                if(started) {
                    i += 1
                    var msg = myHandler.obtainMessage()
                    msg.what = 1
                    msg.arg1 = i
                    myHandler.sendMessage(msg)
                } else {
                    i=0
                }
            }
        }.start()

        btnStart.setOnClickListener {
            started = true
            Log.d("Timer", "started")
        }
        btnStop.setOnClickListener {
            if(started){
                started = false
                Log.d("Timer", "paused")
            }else{
                text.setText("00:00")
                Log.d("Timer", "restarted")
            }
        }
    }
}