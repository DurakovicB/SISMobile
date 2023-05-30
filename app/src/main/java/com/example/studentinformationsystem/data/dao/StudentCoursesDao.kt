package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.StudentCourses


@Dao
interface StudentCoursesDao {
    @Insert
    fun insertStudentCourses(studentCourses: StudentCourses)

    @Update
    fun updateStudentCourses(studentCourses: StudentCourses)

    @Delete
    fun deleteStudentCourses(studentCourses: StudentCourses)

    @Query("SELECT * FROM student_courses WHERE student_id = :studentId")
    fun getGradesByStudentId(studentId: Int): List<StudentCourses>

    @Query("SELECT * FROM student_courses WHERE student_id = :studentId AND course_id = :courseId")
    fun getGradesByStudentIdAndCourseId(studentId: Int, courseId: Int): List<StudentCourses>
}
