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

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth

        val emailSignUp = findViewById<EditText>(R.id.Email_SignUp)
        val passSignUp = findViewById<EditText>(R.id.Pass_SignUp)
        val signUpBtn = findViewById<Button>(R.id.btnSignUp)

        signUpBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                emailSignUp.text.toString().trim(),
                passSignUp.text.toString().trim()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser

                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)

                        Toast.makeText(
                            baseContext,
                            "Authentication Success.",
                            Toast.LENGTH_LONG,
                        ).show()


                    } else {

                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_LONG,
                        ).show()

                    }
                }

        }

    }


}
