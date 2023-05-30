package com.example.studentinformationsystem.data.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentinformationsystem.data.classes.Notification
import com.example.studentinformationsystem.data.dao.NotificationDao
import com.example.studentinformationsystem.data.viewmodels.NotificationViewModel

@Composable
fun NotificationsScreen(viewModel: NotificationViewModel) {
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
fun NotifPreview()
{
// Call the NotificationsScreen composable
    val viewModel: NotificationViewModel = viewModel()
    NotificationsScreen(viewModel = viewModel)
}
