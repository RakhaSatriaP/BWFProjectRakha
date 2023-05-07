package com.example.bwfprojectrakha

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Raket(
    val jenisRaket:String,
    val hargaRaket : String,
    val description: String,
    val imgRaket: Int,
    val tahun: String,
    val kriteria : String
) : Parcelable