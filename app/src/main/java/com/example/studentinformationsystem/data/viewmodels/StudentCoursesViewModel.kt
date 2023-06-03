package com.example.studentinformationsystem.data.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.StudentCourses
import com.example.studentinformationsystem.data.dao.StudentCoursesDao
import kotlinx.coroutines.launch

class StudentCoursesViewModel(private val studentCoursesDao: StudentCoursesDao) : ViewModel() {

    //fun selectAll() = StudentCoursesDao.selectAll()

    fun getStudentCoursesByStudentId(studentId: Int) = studentCoursesDao.getGradesByStudentId(studentId)

    fun getStudentCoursesByStudentIdAndCourseId(studentId: Int, courseId: Int) =
        studentCoursesDao.getGradesByStudentIdAndCourseId(studentId, courseId)

    fun insertStudentCourses(studentCourses: StudentCourses) {
        viewModelScope.launch {
            studentCoursesDao.insertStudentCourses(studentCourses)
        }
    }

    fun updateStudentCourses(studentCourses: StudentCourses) {
        viewModelScope.launch {
            studentCoursesDao.updateStudentCourses(studentCourses)
        }
    }

    fun deleteStudentCourses(studentCourses: StudentCourses) {
        viewModelScope.launch {
            studentCoursesDao.deleteStudentCourses(studentCourses)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                StudentCoursesViewModel(application.database.studentCoursesDao())
            }
        }
    }
}
