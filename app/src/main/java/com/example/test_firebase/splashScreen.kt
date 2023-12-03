package com.example.test_firebase

import android.R.anim.fade_out
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivnote = findViewById<ImageView>(R.id.iv_note)

        ivnote.alpha = 0f
        ivnote.animate().setDuration(1500).alpha(1f).withEndAction {
            Thread.sleep(3000)
            val options =
                ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in, fade_out)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent, options.toBundle())
            finish()
        }
    }
}