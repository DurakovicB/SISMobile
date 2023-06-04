package com.example.studentinformationsystem.data.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentinformationsystem.R
import com.example.studentinformationsystem.data.viewmodels.CourseViewModel
import com.example.studentinformationsystem.data.viewmodels.StudentViewModel

@Composable
fun StudentDetailScreen(studentId: Int) {
    val studentViewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)
    val courseViewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)
    val student = studentViewModel.getStudentById(studentId)

    // Retrieve the student's courses using the courseViewModel
    val courses = courseViewModel.getCoursesByStudentId(studentId)
if (student!=null) {
    Column {
        Image(
            painter = painterResource(id = getAvatarResource(student.gender)),
            contentDescription = "Student Avatar"
        )
        Text(text = student.fullName)
        Text(text = student.email)
        Text(text = student.phone)

        // Display the courses
        Text(text = "Courses:")
        courses.forEach { course ->
            Text(text = course.name)
        }
    }
}
}

@Preview
@Composable
fun preview()
{
    StudentDetailScreen(studentId = 2)
}