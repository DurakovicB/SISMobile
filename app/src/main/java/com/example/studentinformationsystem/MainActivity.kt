package com.example.studentinformationsystem

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentinformationsystem.data.dao.UserDao
import com.example.studentinformationsystem.data.classes.Course
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.classes.Professor
import com.example.studentinformationsystem.data.classes.Student
import com.example.studentinformationsystem.data.classes.StudentCourses
import com.example.studentinformationsystem.data.classes.User
import com.example.studentinformationsystem.data.dao.CourseDao
import com.example.studentinformationsystem.data.dao.NotificationDao
import com.example.studentinformationsystem.data.dao.ProfessorDao
import com.example.studentinformationsystem.data.dao.StudentCoursesDao
import com.example.studentinformationsystem.data.dao.StudentDao
import com.example.studentinformationsystem.data.ui.CoursesScreen
import com.example.studentinformationsystem.data.ui.HomeScreen
import com.example.studentinformationsystem.data.ui.NotificationsScreen
import com.example.studentinformationsystem.data.ui.ProfessorsScreen
import com.example.studentinformationsystem.data.ui.StudentsScreen
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        //populateDatabase(database.courseDao(),database.notificationDao(),database.professorDao(),database.studentDao(),database.studentCoursesDao(),database.userDao())
        /*TODO*/
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
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

@RequiresApi(Build.VERSION_CODES.O)
fun populateDatabase(courseDao: CourseDao, notificationDao: NotificationDao, professorDao: ProfessorDao, studentDao: StudentDao, studentCoursesDao: StudentCoursesDao, userDao: UserDao) {
    val courses = listOf(
        Course(1, "Calculus II", "Second installment of calculus", 5),
        Course(2, "Calculus I", "Math basics", 5),
        Course(3, "Intro to Web", "Basics of Web Development", 2),
        Course(4, "Intro to Mobile", "Mobile programming - Android Studio / Java", 2),
        Course(5, "Discrete Maths", "Intermediatery mathematics, including cryptography", 2),
        Course(6, "Database Design", "Intermediary course on database theory and MySQL", 1)
    )

    val notifications = listOf(
        Notification(1, "Regarding exam registration", "Dear Students, on the LMS you can find a video tutorial on how to register for your exams. Please be aware that students will not be able to do exams that they haven't previously registered for.", Date.from(
            LocalDateTime.parse("2023-04-12T15:39:48").atZone(ZoneId.systemDefault()).toInstant())),
        Notification(2, "Happy Holidays", "The staff of the University wishes you happy holidays. We hope to see you soon!", Date.from(
            LocalDateTime.parse("2023-04-17T15:17:33").atZone(ZoneId.systemDefault()).toInstant())),
        Notification(3, "Erasmus Information", "Information about upcoming erasmus programs will be available on our website. Be sure to check it regularly.", Date.from(
            LocalDateTime.parse("2023-05-17T15:21:01").atZone(ZoneId.systemDefault()).toInstant()))
    )


    val professors = listOf(
        Professor(1, "dzelilam@gmail.com", "Dzelila Mehanovic", "061827455", Date.from(
            LocalDate.parse("1990-12-12").atStartOfDay(
                ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(2, "dinokeco@ibu.edu.ba", "Dino Keco", "062234123", Date.from(
            LocalDate.parse("1973-04-12").atStartOfDay(
                ZoneId.systemDefault()).toInstant()), "Male"),
        Professor(4, "elma.avdic@ibu.edu.ba", "Elma Avdic", "061332412", Date.from(
            LocalDate.parse("1975-04-01").atStartOfDay(
                ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(5, "saidasultanic@stu.ibu.edu.ba", "Saida Sultanic", "062445611", Date.from(
            LocalDate.parse("1967-02-07").atStartOfDay(ZoneId.systemDefault()).toInstant()), "Female"),
        Professor(7, "becirisakovic@ibu.edu.ba", "Becir Isakovic", "06222435", Date.from(
            LocalDate.parse("1996-06-09").atStartOfDay(
                ZoneId.systemDefault()).toInstant()), "Male")
    )


    val students = listOf(
        Student(1, "ahmed.durakovic@gmail.ba", "Ahmed Durakovic", "1231231231", "Male"),
        Student(2, "melisa22@gmail.com", "Melisa Brulic", "44", "Female"),
        Student(3, "merisa4@gmai.com", "Merisa Brrulic", "4122", "Female"),
        Student(4, "bilal.durakovic@stu.ibu.edu.ba", "Bilal Durakovic", "062030834", "Male"),
        Student(5, "farisrizvanovic@gmail.com", "Faris Rizvanovic", "322412", "Male")
    )
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



    val users = listOf(
        User(1, "ahmed.durakovic@gmail.ba", "password123",1),
        User(2, "melisa22@gmail.com", "password123",2)
    )

    courses.forEach { course ->
        courseDao.insertCourse(course)
    }

    notifications.forEach { notification ->
        notificationDao.insertNotification(notification)
    }

    professors.forEach { professor ->
        professorDao.insertProfessor(professor)
    }

    students.forEach { student ->
        studentDao.insertStudent(student)
    }

    studentCourses.forEach { studentCourse ->
        studentCoursesDao.insertStudentCourses(studentCourse)
    }

    users.forEach { user ->
        userDao.insertUser(user)
    }

}



