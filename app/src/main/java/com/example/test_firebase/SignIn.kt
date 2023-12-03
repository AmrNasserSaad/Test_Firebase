package com.example.test_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth

        val emailSignIn = findViewById<EditText>(R.id.addEmail)
        val passSignIn = findViewById<EditText>(R.id.addPass)
        val signInBtn = findViewById<Button>(R.id.btnSignIn)

        signInBtn.setOnClickListener {

            auth.signInWithEmailAndPassword(
                emailSignIn.text.toString().trim(),
                passSignIn.text.toString().trim()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)

                        Toast.makeText(
                            baseContext,
                            "Sign in  Success.",
                            Toast.LENGTH_LONG,
                        ).show()


                    } else {

                        Toast.makeText(
                            baseContext,
                            "Sign in  failed.",
                            Toast.LENGTH_LONG,
                        ).show()

                    }
                }

        }


    }

}