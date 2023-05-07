package com.example.bwfprojectrakha

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var tampilanRaket : RecyclerView
    private val list = ArrayList<Raket>()

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportActionBar?.title = "Rekomendasi Raket Badminton"

    tampilanRaket = findViewById(R.id.tampilanRaket)
    tampilanRaket.setHasFixedSize(true)

    list.addAll(getListRaket())
    showRecyclerList()

    }

    private fun getListRaket(): ArrayList<Raket> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val datatahun = resources.getStringArray(R.array.data_tahunproduksi)
        val datakriteria = resources.getStringArray(R.array.data_kriteria)
        val listRaket = ArrayList<Raket>()
        for (i in dataName.indices) {
            val raket = Raket(dataName[i],dataHarga[i], dataDescription[i], dataPhoto.getResourceId(i, -1),datatahun[i],datakriteria[i])
            listRaket.add(raket)
        }
        return listRaket
    }

    private fun showRecyclerList() {
        tampilanRaket.layoutManager = LinearLayoutManager(this)
        val lisRaketAdapter = ListRaketAdapter(list)
        tampilanRaket.adapter = lisRaketAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.aboutme, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveToAboutme = Intent(this@MainActivity, aboutMe::class.java)
                startActivity(moveToAboutme)
            }
        }
        return true
    }

}