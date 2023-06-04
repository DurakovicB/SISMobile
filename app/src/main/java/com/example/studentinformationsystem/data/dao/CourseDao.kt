package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.Course
import com.example.studentinformationsystem.data.classes.Notification

@Dao
interface CourseDao {

    @Query ("Select * from course")
    fun selectAll():List<Course>
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

    @Query("Select * from student_courses sc join course c on sc.course_id=c.id where student_id = :studentId")
    fun getCoursesForStudent(studentId:Int):List<Course>
}
