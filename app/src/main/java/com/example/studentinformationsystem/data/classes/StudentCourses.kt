package com.example.studentinformationsystem.data.classes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_courses")
data class StudentCourses(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val student_id: Int,
    val course_id: Int,
    val percentageTotalAmount: Int,
    val percentageAcquired: Int,
    val gradeTitle: String
)
