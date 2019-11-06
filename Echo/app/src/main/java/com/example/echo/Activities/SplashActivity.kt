package com.example.echo.Activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.echo.R

class SplashActivity : AppCompatActivity() {
    var permissionstring = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.MODIFY_AUDIO_SETTINGS,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.PROCESS_OUTGOING_CALLS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (!allpermissions(this@SplashActivity, *permissionstring)) {
            ActivityCompat.requestPermissions(this@SplashActivity, permissionstring, 151)

        } else {


            Handling()

        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            151 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[2] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[4] == PackageManager.PERMISSION_GRANTED
                ) {
                    Handling()


                    return
                } else {
                    Toast.makeText(this@SplashActivity, "please provide all permissions", Toast.LENGTH_SHORT).show()
                    this.finish()
                }
                return

            }
            else -> {
                Toast.makeText(this@SplashActivity, "Something wrong", Toast.LENGTH_SHORT).show()
                this.finish()
                return
            }


        }
    }

    fun allpermissions(context: Context, vararg permissions: String): Boolean {
        var haspermissions = true
        for (permission in permissions) {
            val res = context.checkCallingOrSelfPermission(permission)
            if (res != PackageManager.PERMISSION_GRANTED) {
                var haspermissions = true
            }

        }
        return haspermissions

    }

    fun Handling() {
        Handler().postDelayed({
            val start = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(start)
            this.finish()

        }, 1000)

    }

}
