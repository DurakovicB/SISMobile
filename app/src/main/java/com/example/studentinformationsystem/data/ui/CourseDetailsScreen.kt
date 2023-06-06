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
import com.example.studentinformationsystem.R
import com.example.studentinformationsystem.data.viewmodels.CourseViewModel
import com.example.studentinformationsystem.data.viewmodels.ProfessorViewModel
import com.example.studentinformationsystem.data.viewmodels.StudentCoursesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CourseDetailsScreen(
    courseId: Int,
    navController: NavController,
) {
    val courseViewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)
    val professorViewModel: ProfessorViewModel = viewModel(factory = ProfessorViewModel.factory)
    val studentCoursesViewModel: StudentCoursesViewModel = viewModel(factory = StudentCoursesViewModel.factory)

    val course = courseViewModel.getCourseById(courseId)
    val professor = professorViewModel.getProfessorById(course?.professorId ?: 0)
    val studentCourses = studentCoursesViewModel.getStudentCoursesByStudentIdAndCourseId(1, courseId)
    val totalPoints = studentCourses.sumBy { it.percentageAcquired * it.percentageTotalAmount / 100 }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Course Details",
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
                    Image(
                        painter = painterResource(id = R.drawable.book),
                        contentDescription = "Course Logo",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = course?.name ?: "",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Instructor: ${professor?.fullName ?: ""}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Description: ${course?.description ?: ""}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Grades: ",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    studentCourses.forEach { studentCourse ->
                        val gradeText = "${studentCourse.gradeTitle} (${studentCourse.percentageTotalAmount}%): " +
                                "${studentCourse.percentageAcquired * studentCourse.percentageTotalAmount / 100} Points"
                        Text(
                            text = gradeText,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    Text(
                        text = "Total Points: $totalPoints",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    )
}


