package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (var videoList:List<video>):RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    // ViewHolder untuk menyimpan referensi elemen tata letak item daftar
    inner class ListViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val gambar:ImageView=itemview.findViewById(R.id.img_view)
        val judulvideo:TextView=itemview.findViewById(R.id.tv_judul_video)
        val description:TextView=itemview.findViewById(R.id.tv_description)
    }

    fun setFilteredList(videoList: List<video>){
        this.videoList = videoList
        notifyDataSetChanged()
    }

    // Membuat ViewHolder baru saat dibutuhkanBe
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        return ListViewHolder(itemView)
    }

    // Mengikat data ke ViewHolder pada posisi tertentu dalam daftar
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (gambar,judul,description) = videoList[position]

        // Menetapkan nilai ke elemen UI di dalam ViewHolder
        holder.gambar.setImageResource(gambar)
        holder.judulvideo.text = judul
        holder.description.text = description

        // Menambahkan listener klik untuk membuka DetailActivity saat item diklik
        holder.itemView.setOnClickListener{
            val intentDetail= Intent(holder.itemView.context,DetailActivity::class.java)
            intentDetail.putExtra("shadow",videoList[holder.adapterPosition])
            holder.itemView.context.startActivities(arrayOf(intentDetail))
        }

    }

    // Mengembalikan jumlah total item dalam daftar
    override fun getItemCount(): Int = videoList.size
}