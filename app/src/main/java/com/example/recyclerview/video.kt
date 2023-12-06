package com.example.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Anotasi @Parcelize untuk mengenerate implementasi Parcelable secara otomatis
@Parcelize
data class video (
    val gambar:Int,            // ID sumber daya gambar untuk video
    val judul:String,          // Judul video
    val data_deskripsi:String, // Deskripsi atau konten video
    val videoId:Int            // ID sumber daya video (jika ada)
) : Parcelable