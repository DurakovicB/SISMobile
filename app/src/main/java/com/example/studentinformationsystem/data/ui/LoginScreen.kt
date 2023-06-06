package com.example.studentinformationsystem.data.ui

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.R
import com.example.studentinformationsystem.data.viewmodels.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: UserViewModel = viewModel(factory = UserViewModel.factory)
    var email by remember { mutableStateOf("ahmed.durakovic@gmail.com") }
    var password by remember { mutableStateOf("123456") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.studentcap),
            contentDescription = "Login Image",
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Text(
            text = "Student Information System",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            label = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardActions = KeyboardActions(
                onDone = { performLogin(viewModel, email, password, context, navController) }
            )
        )

        Button(
            onClick = { performLogin(viewModel, email, password, context, navController) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(text = "Login")
        }
    }
}




private fun performLogin(userViewModel: UserViewModel, email: String, password: String, context: Context,navController: NavController) {
    val isUserExists = userViewModel.checkUserExistence(email, password)
    if (isUserExists) {
        // Login successful
        navController.navigate("home")
    } else {
        // Invalid credentials
        showToast(context, "Invalid credentials!")
    }
}


private fun showToast(context: Context, message: String) {
    // Show a toast message with the provided text
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}