package com.example.recyclerview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class videoActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur tata letak aktivitas video
        setContentView(R.layout.activity_video)

        // Mendapatkan ID sumber daya video dari intent
        val videoId=intent.getIntExtra("videoId",-1)

        // Inisialisasi VideoView dari layout
        videoView=findViewById(R.id.vv_video)

        // Mendefinisikan path video menggunakan URI dengan skema android.resource
        val videoPath="android.resource://${packageName}/${videoId}"

        // Menetapkan URI video ke VideoView
        videoView.setVideoURI(Uri.parse(videoPath))

        // Menambahkan MediaController untuk mengontrol pemutaran video
        videoView.setMediaController(MediaController(this))

        // Memulai pemutaran video
        videoView.start()
    }
}