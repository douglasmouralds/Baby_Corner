package com.example.babycorner.Schedule

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey val id: Int,
    val title: String,          // Renomeado de 'name' para 'title'
    val description: String,    // Adicionando 'description'
    val dateTime: Long
)
