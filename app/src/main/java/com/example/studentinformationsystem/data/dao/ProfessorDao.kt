package com.example.studentinformationsystem.data.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.Professor


@Dao
interface ProfessorDao {
    @Insert
    fun insertProfessor(professor: Professor)

    @Update
    fun updateProfessor(professor: Professor)

    @Delete
    fun deleteProfessor(professor: Professor)

    @Query("SELECT DISTINCT professor.* FROM professor INNER JOIN course ON course.professor_id = professor.id INNER JOIN student_courses ON student_courses.course_id = course.id WHERE student_courses.student_id = :studentId")
    fun getProfessorsByStudentId(studentId: Int): List<Professor>

    @Query("SELECT * FROM professor WHERE id = :id")
    fun getProfessorById(id: Int): Professor?
}
