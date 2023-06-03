package com.example.studentinformationsystem.data.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "professor")
data class Professor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val email: String,
    val fullName: String,
    val phone: String?,
    val dateOfBirth: Date,
    val gender: String?
)
