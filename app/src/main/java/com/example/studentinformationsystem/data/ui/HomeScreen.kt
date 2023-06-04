package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.data.classes.Course
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.classes.Professor
import com.example.studentinformationsystem.data.classes.Student
import com.example.studentinformationsystem.data.classes.StudentCourses
import com.example.studentinformationsystem.data.classes.User
import com.example.studentinformationsystem.data.viewmodels.CourseViewModel
import com.example.studentinformationsystem.data.viewmodels.NotificationViewModel
import com.example.studentinformationsystem.data.viewmodels.ProfessorViewModel
import com.example.studentinformationsystem.data.viewmodels.StudentCoursesViewModel
import com.example.studentinformationsystem.data.viewmodels.StudentViewModel
import com.example.studentinformationsystem.data.viewmodels.UserViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
//    insertNotifications()
//    insertProfessors()
//    insertCourses()
//    insertStudents()
//    insertStudentCourses()
//    insertUsers()

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
                    onClick = {  navController.navigate("notifications")},
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
                    onClick = { navController.navigate("students") },
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
                    onClick = { navController.navigate("courses") },
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
                    onClick = { navController.navigate("professors") },
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
@RequiresApi(Build.VERSION_CODES.O)
private fun insertNotifications() {
    val viewModel: NotificationViewModel = viewModel(factory = NotificationViewModel.factory)
    val notifications = listOf(
        Notification(1, "Regarding exam registration", "Dear Students, on the LMS you can find a video tutorial on how to register for your exams. Please be aware that students will not be able to do exams that they haven't previously registered for.", Date.from(
            LocalDateTime.parse("2023-04-12T15:39:48").atZone(ZoneId.systemDefault()).toInstant())),
        Notification(2, "Happy Holidays", "The staff of the University wishes you happy holidays. We hope to see you soon!", Date.from(
            LocalDateTime.parse("2023-04-17T15:17:33").atZone(ZoneId.systemDefault()).toInstant())),
        Notification(3, "Erasmus Information", "Information about upcoming erasmus programs will be available on our website. Be sure to check it regularly.", Date.from(
            LocalDateTime.parse("2023-05-17T15:21:01").atZone(ZoneId.systemDefault()).toInstant()))
    )

    notifications.forEach { notification ->
        viewModel.insertNotification(notification)
    }
}
@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun insertCourses() {
    val viewModel: CourseViewModel = viewModel(factory = CourseViewModel.factory)
    val courses = listOf(
        Course(1, "Calculus II", "Second installment of calculus", 5),
        Course(2, "Calculus I", "Math basics", 5),
        Course(3, "Intro to Web", "Basics of Web Development", 2),
        Course(4, "Intro to Mobile", "Mobile programming - Android Studio / Java", 2),
        Course(5, "Discrete Maths", "Intermediatery mathematics, including cryptography", 2),
        Course(6, "Database Design", "Intermediary course on database theory and MySQL", 1)
    )

    courses.forEach { course ->
        viewModel.insertCourse(course)
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun insertProfessors() {
    val viewModel: ProfessorViewModel = viewModel(factory = ProfessorViewModel.factory)
    val professors = listOf(
        Professor(1, "dzelilam@gmail.com", "Dzelila Mehanovic", "061827455", Date.from(
            LocalDate.parse("1990-12-12").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(2, "dinokeco@ibu.edu.ba", "Dino Keco", "062234123", Date.from(
            LocalDate.parse("1973-04-12").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Male"),
        Professor(4, "elma.avdic@ibu.edu.ba", "Elma Avdic", "061332412", Date.from(
            LocalDate.parse("1975-04-01").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(5, "saidasultanic@stu.ibu.edu.ba", "Saida Sultanic", "062445611", Date.from(
            LocalDate.parse("1967-02-07").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(7, "becirisakovic@ibu.edu.ba", "Becir Isakovic", "06222435", Date.from(
            LocalDate.parse("1996-06-09").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Male")
    )

    professors.forEach { professor ->
        viewModel.insertProfessor(professor)
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun insertStudents() {
    val viewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)
    val students = listOf(
        Student(1, "ahmed.durakovic@gmail.ba", "Ahmed Durakovic", "1231231231", "Male"),
        Student(2, "melisa22@gmail.com", "Melisa Brulic", "44", "Female"),
        Student(3, "merisa4@gmai.com", "Merisa Brrulic", "4122", "Female"),
        Student(4, "bilal.durakovic@stu.ibu.edu.ba", "Bilal Durakovic", "062030834", "Male"),
        Student(5, "farisrizvanovic@gmail.com", "Faris Rizvanovic", "322412", "Male")
    )

    students.forEach { student ->
        viewModel.insertStudent(student)
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun insertStudentCourses() {
    val viewModel: StudentCoursesViewModel = viewModel(factory = StudentCoursesViewModel.factory)
    val studentCourses = listOf(
        StudentCourses(1, 1, 2, 30, 60, "Midterm Exam"),
        StudentCourses(2, 1, 2, 40, 75, "Project"),
        StudentCourses(3, 1, 2, 30, 55, "Final"),
        StudentCourses(4, 1, 3, 10, 100, "Quiz 1"),
        StudentCourses(5, 1, 1, 5, 40, "Quiz 1"),
        StudentCourses(6, 1, 1, 30, 70, "Midterm"),
        StudentCourses(7, 1, 2, 10, 85, "Quiz"),
        StudentCourses(8, 1, 3, 30, 60, "Final"),
        StudentCourses(9, 2, 1, 30, 80, "Midterm"),
        StudentCourses(10, 2, 3, 10, 70, "Quiz"),
        StudentCourses(11, 3, 1, 30, 65, "Final"),
        StudentCourses(12, 3, 2, 30, 90, "Midterm"),
        StudentCourses(13, 4, 1, 30, 75, "Midterm"),
        StudentCourses(14, 4, 3, 10, 80, "Quiz"),
        StudentCourses(15, 5, 2, 10, 75, "Final"),
        StudentCourses(16, 5, 3, 30, 70, "Midterm")
    )

    studentCourses.forEach { studentCourse ->
        viewModel.insertStudentCourses(studentCourse)
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun insertUsers() {
    val viewModel: UserViewModel = viewModel(factory = UserViewModel.factory)
    val users = listOf(
        User(1, "ahmed.durakovic@gmail.com", "123456", student_id = 1),
        User(2, "melisa22@gmail.com", "password", student_id = 2),
        User(3, "merisa4@gmai.com", "pass123", student_id = 3),
        User(4, "bilal.durakovic@stu.ibu.edu.ba", "user123", student_id = 4),
        User(5, "farisrizvanovic@gmail.com", "pass321", student_id = 5)
    )

    users.forEach { user ->
        viewModel.insertUser(user)
    }
}

