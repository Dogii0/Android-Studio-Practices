package kr.ac.dankook.mobile.myapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val text = findViewById<TextView>(R.id.text)

        val fileName = "internal.txt"

        var fileBody = "File for testing"
        var i = 0
        btn.setOnClickListener{
            if(btn.getText().toString()=="Write"){
                when(i){
                    0->{
                        fileBody = "File for testing 0"
                        i += 1
                    }
                    1->{
                        fileBody = "File for testing 1"
                        i += 1
                    }
                    2->{
                        fileBody = "File for testing 2"
                        i+=1
                    }
                    3->{
                        fileBody = "..."
                    }
                }

                applicationContext.openFileOutput(fileName, MODE_PRIVATE).use {
                    it.write(fileBody.toByteArray())
                    it.close()
                }
                btn.setText("Read")
                text.setText("New number written to file")
                Log.d("FILETEST", "new number written")
            }else{
                applicationContext.openFileInput(fileName).use {
                    var txt = it.bufferedReader().readLine()
                    text.setText(txt)
                    btn.setText("Write")
                    Log.d("FILETEST", "---> $txt")
                    it.close()
                }
            }
        }
    }
}