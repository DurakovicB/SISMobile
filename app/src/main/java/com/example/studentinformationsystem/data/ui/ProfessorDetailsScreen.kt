package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import com.example.studentinformationsystem.data.viewmodels.ProfessorViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfessorDetailsScreen(
    professorId: Int,
    navController: NavController,
) {
    val professorViewModel: ProfessorViewModel = viewModel(factory = ProfessorViewModel.factory)
    val courseViewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)
    val professor = professorViewModel.getProfessorById(professorId)
    val courses = courseViewModel.getCoursesByProfessorId(professorId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Professor Details",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    professor?.let {
                        Image(
                            painter = painterResource(id = getProfessorAvatarResource(professor.gender)),
                            contentDescription = "Professor Avatar",
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape)
                                .padding(bottom = 16.dp)
                        )
                        Text(
                            text = professor.fullName,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = professor.email,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = professor.phone,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 32.dp)
                        )
                    }
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

