package com.example.studentinformationsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentinformationsystem.data.ui.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

// Call the HomeScreen composable with navigation actions
            HomeScreen(
                onNavigateToNotifications = { navigateToNotifications() },
                onNavigateToColleagues = { navigateToColleagues() },
                onNavigateToCoursesGrades = { navigateToCoursesGrades() },
                onNavigateToProfessors = { navigateToProfessors() }
            )

        }
    }
}

fun navigateToNotifications() {
    // Navigate to the Notifications screen
}

fun navigateToColleagues() {
    // Navigate to the Colleagues screen
}

fun navigateToCoursesGrades() {
    // Navigate to the Courses/Grades screen
}

fun navigateToProfessors() {
    // Navigate to the Professors screen
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen(
        onNavigateToNotifications = { navigateToNotifications() },
        onNavigateToColleagues = { navigateToColleagues() },
        onNavigateToCoursesGrades = { navigateToCoursesGrades() },
        onNavigateToProfessors = { navigateToProfessors() }
    )
}