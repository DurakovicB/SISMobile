package com.example.exlabexmobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.studentinformationsystem.data.classes.Course
import com.example.studentinformationsystem.data.dao.CourseDao
import com.example.studentinformationsystem.data.DateConverter
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.dao.NotificationDao
import com.example.studentinformationsystem.data.classes.Professor
import com.example.studentinformationsystem.data.dao.ProfessorDao
import com.example.studentinformationsystem.data.classes.Student
import com.example.studentinformationsystem.data.classes.StudentCourses
import com.example.studentinformationsystem.data.dao.StudentCoursesDao
import com.example.studentinformationsystem.data.dao.StudentDao
import com.example.studentinformationsystem.data.classes.User
import com.example.studentinformationsystem.data.UserDao

@Database(
    entities = [
        Course::class,
        Notification::class,
        Professor::class,
        Student::class,
        StudentCourses::class,
        User::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class) // Add the TypeConverter here
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun notificationDao(): NotificationDao
    abstract fun professorDao(): ProfessorDao
    abstract fun studentDao(): StudentDao
    abstract fun studentCoursesDao(): StudentCoursesDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .createFromAsset("systeminformationsystem.sql")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
