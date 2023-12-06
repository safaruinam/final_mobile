package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recyclerview.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    // Deklarasi variabel binding menggunakan View Binding
    private lateinit var binding: ActivityLoginBinding

    // Deklarasi variabel EditText dan Button
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi UI elements menggunakan binding
        username = binding.username
        password = binding.password
        loginButton = binding.loginButton

        // Menambahkan listener klik pada tombol login
        binding.loginButton.setOnClickListener(View.OnClickListener {
            // Memeriksa apakah username dan password sesuai dengan yang diharapkan
            if (binding.username.text.toString() == "Saparuddin" && binding.password.text.toString() == "60900121046") {
                // Menampilkan pesan sukses dan memulai aktivitas utama
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@Login, MainActivity::class.java))
            } else {
                // Menampilkan pesan gagal login jika username atau password tidak sesuai
                Toast.makeText(this, "Gagal Login", Toast.LENGTH_SHORT).show()
            }
        })
    }
}