package com.example.studentinformationsystem.data.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.Professor
import com.example.studentinformationsystem.data.dao.ProfessorDao
import kotlinx.coroutines.launch

class ProfessorViewModel(private val professorDao: ProfessorDao) : ViewModel() {

    fun getProfessorsByStudentId(studentId: Int) = professorDao.getProfessorsByStudentId(studentId)

    fun getProfessorById(professorId: Int) = professorDao.getProfessorById(professorId)
    fun selectAll() = professorDao.selectAll()

    fun insertProfessor(professor: Professor) {
        viewModelScope.launch {
            professorDao.insertProfessor(professor)
        }
    }

    fun updateProfessor(professor: Professor) {
        viewModelScope.launch {
            professorDao.updateProfessor(professor)
        }
    }

    fun deleteProfessor(professor: Professor) {
        viewModelScope.launch {
            professorDao.deleteProfessor(professor)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                ProfessorViewModel(application.database.professorDao())
            }
        }
    }
}
