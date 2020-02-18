package com.directferries.androidtest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarEntity(
    @PrimaryKey val id: String,
    val make: String,
    val model: String
)