package com.example.studentinformationsystem.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.Course
import com.example.studentinformationsystem.data.dao.CourseDao
import kotlinx.coroutines.launch

class CourseViewModel(private val courseDao: CourseDao) : ViewModel() {

    fun selectAll() = courseDao.selectAll()

    fun getCourseById(courseId: Int) = courseDao.getCourseById(courseId)

    fun getCoursesByProfessorId(professorId: Int) = courseDao.getCoursesByProfessorId(professorId)

    fun getCoursesByStudentId(studentId:Int)=courseDao.getCoursesForStudent(studentId)
    fun insertCourse(course: Course) {
        viewModelScope.launch {
            courseDao.insertCourse(course)
        }
    }

    fun updateCourse(course: Course) {
        viewModelScope.launch {
            courseDao.updateCourse(course)
        }
    }

    fun deleteCourse(course: Course) {
        viewModelScope.launch {
            courseDao.deleteCourse(course)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                CourseViewModel(application.database.courseDao())
            }
        }
    }
}
