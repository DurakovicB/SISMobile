package com.example.studentinformationsystem.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.studentinformationsystem.data.classes.User


@Dao
interface UserDao {


    @Query ("Select * from users")
    fun selectAll():List<User>
    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUserById(id: Int): User?

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): User?

    @Query("SELECT COUNT(*) FROM users WHERE email = :email AND password = :password")
    fun getUserCountByEmailAndPassword(email: String, password: String): Int

}
