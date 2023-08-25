package kr.ac.dankook.mobile.myapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val permissionText = findViewById<TextView>(R.id.text)

        if(cameraPermission == PackageManager.PERMISSION_GRANTED) {
            Log.d("DKMOBILE", "CAMERA permission already granted")
            permissionText.setText("CAMERA permission already granted")
        } else {
            permissionText.setText("CAMERA permission not granted")
        }

        val btnCamera = findViewById<Button>(R.id.permis)
        btnCamera.setOnClickListener {
            Log.d("DKMobile","CAMERA button pressed.")
            if(cameraPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA), 99)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val permissionText = findViewById<TextView>(R.id.text)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            99 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("DKMOBILE", "CAMERA permission granted now")
                    permissionText.setText("CAMERA permission granted now")
                } else {
                    Log.d("DKMOBILE", "CAMERA permission not granted")
                    permissionText.setText("CAMERA permission not granted")
                }
            }
        }
    }
}