package com.example.studentinformationsystem.data.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentinformationsystem.R
import com.example.studentinformationsystem.data.classes.Professor
import com.example.studentinformationsystem.data.viewmodels.ProfessorViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfessorsScreen(navController: NavController) {
    val viewModel: ProfessorViewModel = viewModel(factory = ProfessorViewModel.factory)

    val professors = viewModel.selectAll()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Professors") },
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
                itemsIndexed(professors) { index, professor ->
                    if (index % 2 == 0) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            ProfessorCard(professor, imageSize = 150.dp,navController)
                            if (index + 1 < professors.size) {
                                ProfessorCard(professor = professors[index + 1], imageSize = 150.dp,navController)
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
private fun ProfessorCard(professor: Professor, imageSize: Dp,navC:NavController) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 15.dp)
            .clickable(onClick = {    navC.navigate("professor/${professor.id}")})
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = getProfessorAvatarResource(professor.gender)),
                contentDescription = "Professor Image",
                modifier = Modifier
                    .size(imageSize)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = professor.fullName, style = MaterialTheme.typography.bodyMedium)
            Text(text = professor.id.toString(), style = MaterialTheme.typography.bodySmall)
            // Add any other UI components to display professor details
        }
    }
}

 fun getProfessorAvatarResource(gender: String): Int {
    return when (gender) {
        "Male" -> R.drawable.maleprofessoravatar
        "Female" -> R.drawable.femaleprofessoravatar
        else -> R.drawable.maleprofessoravatar
    }
}


