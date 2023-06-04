package com.example.studentinformationsystem.data.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.User
import com.example.studentinformationsystem.data.dao.UserDao
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {

    fun getUserById(userId: Int) = userDao.getUserById(userId)

     fun checkUserExistence(email: String, password: String): Boolean {
        val userCount = userDao.getUserCountByEmailAndPassword(email, password)
        return userCount > 0
    }

    fun getUserByEmail(email: String) = userDao.getUserByEmail(email)

    fun selectAll() = userDao.selectAll()


    fun insertUser(user: User) {
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userDao.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            userDao.deleteUser(user)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                UserViewModel(application.database.userDao())
            }
        }
    }
}
