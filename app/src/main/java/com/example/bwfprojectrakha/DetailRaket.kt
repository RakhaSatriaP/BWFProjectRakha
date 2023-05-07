package com.example.bwfprojectrakha

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView


class DetailRaket : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_raket)

        val dataRaket = intent.getParcelableExtra<Raket>("key_raket")!! as Raket

        val imgRaket = findViewById<ImageView>(R.id.fotooDiCardView)
        val jenisRaket = findViewById<TextView>(R.id.jenissDicardView)
        val hargaRaket = findViewById<TextView>(R.id.hargaaDiCardView)
        val description = findViewById<TextView>(R.id.desccDiCardView)
        val tahun = findViewById<TextView>(R.id.tahunnDiCardView)
        val kriteria = findViewById<TextView>(R.id.kriteriaaDicardView)

        jenisRaket.text = dataRaket.jenisRaket
        hargaRaket.text = dataRaket.hargaRaket
        description.text = dataRaket.description
        imgRaket.setImageResource(dataRaket.imgRaket)
        tahun.text = dataRaket.tahun
        kriteria.text = dataRaket.kriteria
    }

   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sharemenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when (item.itemId) {
            R.id.share -> {
                val url = "https://youtube.com"
                val intent = Intent(Intent.ACTION_SEND)
                intent.type="text/plain"
                intent.putExtra("Share this",url)
                val sharee = Intent.createChooser(intent,"Share Ke : ")
                startActivity(sharee)
            }
        }
        return true
    }
}