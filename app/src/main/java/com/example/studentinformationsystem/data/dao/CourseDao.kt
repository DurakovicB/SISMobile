package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.Course

@Dao
interface CourseDao {
    @Insert
    fun insertCourse(course: Course)

    @Update
    fun updateCourse(course: Course)

    @Delete
    fun deleteCourse(course: Course)

    @Query("SELECT * FROM course WHERE id = :id")
    fun getCourseById(id: Int): Course?

    @Query("SELECT * FROM course WHERE professor_id = :professorId")
    fun getCoursesByProfessorId(professorId: Int): List<Course>
}
