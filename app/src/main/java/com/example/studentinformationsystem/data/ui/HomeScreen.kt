package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(onNavigateToNotifications: () -> Unit, onNavigateToColleagues: () -> Unit, onNavigateToCoursesGrades: () -> Unit, onNavigateToProfessors: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Student Information System") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { onNavigateToNotifications() },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Notifications, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Notifications")
                    }
                }

                Button(
                    onClick = { onNavigateToColleagues() },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Colleagues")
                    }
                }

                Button(
                    onClick = { onNavigateToCoursesGrades() },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Call, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Courses/Grades")
                    }
                }

                Button(
                    onClick = { onNavigateToProfessors() },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Professors")
                    }
                }
            }
        }
    )
}
@Composable
@Preview
fun HomePreview(){
    // Define navigation actions
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

// Call the HomeScreen composable with navigation actions
    HomeScreen(
        onNavigateToNotifications = { navigateToNotifications() },
        onNavigateToColleagues = { navigateToColleagues() },
        onNavigateToCoursesGrades = { navigateToCoursesGrades() },
        onNavigateToProfessors = { navigateToProfessors() }
    )
}
