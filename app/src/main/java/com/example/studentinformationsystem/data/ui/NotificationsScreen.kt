package com.example.studentinformationsystem.data.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.dao.NotificationDao
import com.example.studentinformationsystem.data.viewmodels.NotificationViewModel

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun NotificationsScreen(navController: NavController) {
    val viewModel: NotificationViewModel = viewModel(factory = NotificationViewModel.factory)

    val notifications = viewModel.selectAll()

    LazyColumn {
        items(notifications) { notification ->
            Text(text = notification.title)
            Text(text = notification.description)
            // Add any other UI components to display notification details
        }
    }
}

@Composable
@Preview
fun NotifPreview() {

}