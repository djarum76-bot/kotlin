package com.example.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Agent(var nama: String, var username: String, var deskripsi: String, var photo: Int): Parcelable