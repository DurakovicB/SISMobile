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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.data.ui.AppBarHeight
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
                modifier = Modifier.padding(top = AppBarHeight),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
            ) {
                items(students) { student ->
                    Text(text = student.fullName)
                    Text(text = student.id.toString())
                    // Add any other UI components to display notification details
                }
            }
        }
    )

}