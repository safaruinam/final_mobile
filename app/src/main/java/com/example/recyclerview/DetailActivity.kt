package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur tata letak aktivitas detail
        setContentView(R.layout.activity_detail)

        // Mendapatkan objek Parcelable dari intent
        val receivedData=if (Build.VERSION.SDK_INT>=33){
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<video>("shadow")
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<video>("shadow")
        }

        // Inisialisasi elemen UI
        val gambar:ImageView=findViewById(R.id.img_gambar)
        val judul:TextView=findViewById(R.id.tv_Judul)
        val description:TextView=findViewById(R.id.tv_description)
        val playButton:ImageView=findViewById(R.id.tombol_play)

        // Memeriksa apakah data yang diterima tidak null
        if (receivedData!=null){
            Log.d("recived", receivedData.toString())

            // Menetapkan gambar, judul, dan deskripsi ke elemen UI
            gambar.setImageResource(receivedData.gambar)
            judul.text=receivedData.judul
            description.text=receivedData.data_deskripsi

            // Menambahkan listener untuk tombol putar
            playButton.setOnClickListener{
                // Membuat intent untuk memulai aktivitas video dan mengirim ID video
                val videoIntent= Intent(this,videoActivity::class.java)
                videoIntent.putExtra("videoId",receivedData.videoId)
                startActivity(videoIntent)
            }
        }
    }
}