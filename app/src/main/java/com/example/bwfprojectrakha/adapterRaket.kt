package com.example.bwfprojectrakha

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListRaketAdapter(private val listRaket: ArrayList<Raket> ) : RecyclerView.Adapter<ListRaketAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo : ImageView = itemView.findViewById(R.id.fotoDiCardView)
        val jenis : TextView = itemView.findViewById(R.id.jenisDicardView)
        val desc : TextView = itemView.findViewById(R.id.descDiCardView)
        val harga: TextView = itemView.findViewById(R.id.hargaDiCardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listRaket.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (jenis, harga, desc, imgRaket, tahun, kriteria) = listRaket[position]
        holder.jenis.text = jenis
        holder.harga.text = harga
        holder.desc.text = desc
        holder.photo.setImageResource(imgRaket)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listRaket[holder.adapterPosition].jenisRaket, Toast.LENGTH_SHORT).show()
            val intentDetail = Intent(holder.itemView.context, DetailRaket::class.java)
            intentDetail.putExtra("key_raket", listRaket[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}