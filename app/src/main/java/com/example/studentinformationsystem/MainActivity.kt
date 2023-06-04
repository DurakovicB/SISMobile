package com.example.studentinformationsystem

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentinformationsystem.data.ui.CoursesScreen
import com.example.studentinformationsystem.data.ui.HomeScreen
import com.example.studentinformationsystem.data.ui.LoginScreen
import com.example.studentinformationsystem.data.ui.NotificationsScreen
import com.example.studentinformationsystem.data.ui.ProfessorsScreen
import com.example.studentinformationsystem.data.ui.StudentsScreen

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        //populateDatabase(database.courseDao(),database.notificationDao(),database.professorDao(),database.studentDao(),database.studentCoursesDao(),database.userDao())
        /*TODO*/
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login"){
                    LoginScreen(navController )
                }
                composable("home") {
                    HomeScreen(navController)
                }
                composable("notifications") {
                    NotificationsScreen(navController)
                }
                composable("students") {
                    StudentsScreen(navController)
                }
                composable("professors") {
                    ProfessorsScreen(navController)
                }
                composable("courses") {
                    CoursesScreen(navController)
                }

            }
        }
    }
}
