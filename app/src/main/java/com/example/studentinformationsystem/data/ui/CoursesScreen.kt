package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.dao.NotificationDao
import com.example.studentinformationsystem.data.viewmodels.NotificationViewModel

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.data.viewmodels.CourseViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CoursesScreen(navController: NavController) {
    val viewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)

    val courses = viewModel.selectAll()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Courses") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(top = AppBarHeight),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
            ) {
                items(courses) { course ->
                    Text(text = course.name)
                    Text(text = course.id.toString())
                    // Add any other UI components to display course details
                }
            }
        }
    )
}

val AppBarHeight = 56.dp
