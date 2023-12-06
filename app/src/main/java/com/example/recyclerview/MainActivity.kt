package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    // Deklarasi variabel RecyclerView dan ArrayList untuk data video
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var list = ArrayList<video>()
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi RecyclerView dan menambahkan data ke ArrayList
        recyclerView = findViewById(R.id.rv_video)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ListAdapter(list)
        recyclerView.adapter = adapter
        list.addAll(getList())
        showRecyclerList()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        // Menambahkan listener klik pada tombol keluar
        val outButton: Button = findViewById(R.id.out)
        outButton.setOnClickListener {
            goToLoginActivity()
        }
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<video>()
            for (i in list) {
                if (i.judul.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter = ListAdapter(filteredList)
                recyclerView.adapter = adapter
            }
        }
    }


    // Fungsi untuk memulai LoginActivity
    private fun goToLoginActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    // Fungsi untuk mendapatkan data video dari resources
    private fun getList(): ArrayList<video> {
        // Mengambil data dari resources menggunakan TypedArray dan StringArray
        val gambar = resources.obtainTypedArray(R.array.data_gambar)
        val dataName = resources.getStringArray(R.array.judul_video)
        val dataDescription = resources.getStringArray(R.array.data_dekripsi)
        val videoId = resources.obtainTypedArray(R.array.video_id)

        // Membuat ArrayList untuk menyimpan data video
        val listVideo = ArrayList<video>()

        // Mengisi ArrayList dengan objek video
        for (i in dataName.indices) {
            val video = video(gambar.getResourceId(i, -1), dataName[i], dataDescription[i], videoId.getResourceId(i, -1))
            listVideo.add(video)
        }

        // Mengembalikan ArrayList yang berisi data video
        return listVideo
    }

    // Fungsi untuk menampilkan data video dalam RecyclerView
    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listAdapter = ListAdapter(list)
        recyclerView.adapter = listAdapter
    }
}