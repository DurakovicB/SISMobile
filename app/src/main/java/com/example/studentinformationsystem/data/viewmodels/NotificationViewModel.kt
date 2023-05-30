package com.example.studentinformationsystem.data.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.studentinformationsystem.data.SISApplication
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.dao.NotificationDao
import kotlinx.coroutines.launch

class NotificationViewModel(private val notificationDao: NotificationDao) : ViewModel() {

    fun getNotificationById(notificationId: Int) = notificationDao.getNotificationById(notificationId)

    fun selectAll() = notificationDao.selectAll()

    fun insertNotification(notification: Notification) {
        viewModelScope.launch {
            notificationDao.insertNotification(notification)
        }
    }

    fun updateNotification(notification: Notification) {
        viewModelScope.launch {
            notificationDao.updateNotification(notification)
        }
    }

    fun deleteNotification(notification: Notification) {
        viewModelScope.launch {
            notificationDao.deleteNotification(notification)
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SISApplication)
                NotificationViewModel(application.database.notificationDao())
            }
        }
    }
}
