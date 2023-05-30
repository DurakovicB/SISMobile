package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.Notification


@Dao
interface NotificationDao {
    @Query ("Select * from notification")
    fun selectAll():List<Notification>

    @Insert
    fun insertNotification(notification: Notification)

    @Update
    fun updateNotification(notification: Notification)

    @Delete
    fun deleteNotification(notification: Notification)

    @Query("SELECT * FROM notification WHERE id = :id")
    fun getNotificationById(id: Int): Notification?
}
