package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.data.viewmodels.CourseViewModel
import com.example.studentinformationsystem.data.viewmodels.StudentViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StudentDetailScreen(studentId: Int, navController: NavController) {
    val studentViewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)
    val courseViewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)
    val student = studentViewModel.getStudentById(studentId)
    val courses = courseViewModel.getCoursesByStudentId(studentId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Student Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            if (student != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = getAvatarResource(student.gender)),
                        contentDescription = "Student Avatar",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = student.fullName,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = student.email,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = student.phone,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 32.dp)
                    )

                    Text(
                        text = "Courses:",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    courses.forEach { course ->
                        Text(
                            text = course.name,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }
        }
    )
}


