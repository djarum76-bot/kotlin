package com.example.intentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val nama: String?,
    val umur: Int?,
    val email: String?,
    val city: String
): Parcelable