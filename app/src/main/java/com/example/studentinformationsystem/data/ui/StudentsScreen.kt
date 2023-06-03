package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.R
import com.example.studentinformationsystem.data.classes.Student
import com.example.studentinformationsystem.data.viewmodels.StudentViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StudentsScreen(navController: NavController) {
    val viewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)

    val students = viewModel.selectAll()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Colleagues") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(top = 56.dp),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
            ) {
                itemsIndexed(students) { index, student ->
                    if (index % 2 == 0) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            StudentCard(student, imageSize=150.dp)
                            if (index + 1 < students.size) {
                                StudentCard(student = students[index + 1], imageSize = 150.dp)

                            } else {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }
    )

}

@Composable
private fun StudentCard(student: Student, imageSize: Dp) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = getAvatarResource(student.gender)),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(imageSize)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = student.fullName, style = MaterialTheme.typography.bodyMedium)
            //Text(text = student.id.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}




@DrawableRes
fun getAvatarResource(gender: String): Int {
    return if (gender == "Male") {
        R.drawable.muskiavatar
    } else {
        R.drawable.zenskiavatar
    }
}