package com.example.studentinformationsystem.data.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.Student
import com.example.studentinformationsystem.data.dao.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val studentDao: StudentDao) : ViewModel() {

    fun selectAll() = studentDao.selectAll()

    fun getColleagues(studentId: Int) = studentDao.selectColleagues(studentId)

    fun getStudentById(studentId: Int) = studentDao.getStudentById(studentId)

    fun insertStudent(student: Student) {
        viewModelScope.launch {
            studentDao.insertStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch {
            studentDao.updateStudent(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            studentDao.deleteStudent(student)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                StudentViewModel(application.database.studentDao())
            }
        }
    }
}
