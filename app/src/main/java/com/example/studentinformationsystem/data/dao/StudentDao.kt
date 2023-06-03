package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.classes.Student


@Dao
interface StudentDao {

    @Query ("Select * from student")
    fun selectAll():List<Student>

    @Insert
    fun insertStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("SELECT student.* FROM student INNER JOIN student_courses ON student_courses.student_id = student.id WHERE student_courses.student_id != :studentId AND student_courses.course_id IN (SELECT course_id FROM student_courses WHERE student_id = :studentId)")
    fun selectColleagues(studentId: Int): List<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): Student?
}
