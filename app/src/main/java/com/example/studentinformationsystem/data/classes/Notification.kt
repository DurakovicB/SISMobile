package com.example.studentinformationsystem.data.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.Timestamp
import java.util.Date

@Entity(tableName = "notification")
data class Notification(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val created_at: Date
)

