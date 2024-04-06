package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private val Any.text: Any
    get() {
        TODO("Not yet implemented")
    }
private val EditText.editText: Any
    get() {
        TODO("Not yet implemented")
    }

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
                binding.password.editText?.text.toString()).addOnCompleteListener {

                    if(it.isSuccessful){
                        Toast.makeText(this,"User Created!!!",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User Not Created!!!",Toast.LENGTH_LONG).show()
                    }

            }
        }
    }
}