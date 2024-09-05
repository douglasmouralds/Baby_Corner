package com.example.babycorner.Schedule

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(navController: NavController, eventId: Int?) {
    val viewModel: EventViewModel = viewModel()
    val event by remember { mutableStateOf(eventId?.let { viewModel.getEvent(it) }) }

    var title by remember { mutableStateOf(event?.title ?: "") }
    var description by remember { mutableStateOf(event?.description ?: "") }
    var dateTime by remember { mutableStateOf(event?.dateTime ?: System.currentTimeMillis()) }

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = if (event == null) "New Event" else "Edit Event") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    if (event == null) {
                        val newEvent = Event(
                            id = viewModel.generateNewEventId(),
                            title = title,
                            description = description,
                            dateTime = dateTime
                        )
                        viewModel.addEvent(newEvent)
                    } else {
                        viewModel.updateEvent(Event(
                            id = event!!.id,
                            title = title,
                            description = description,
                            dateTime = dateTime
                        ))
                    }
                    navController.popBackStack()
                }
            }) {
                Icon(Icons.Default.Star, contentDescription = "Save Event")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            // Adicione o seletor de data e hora aqui, se necessário
        }
    }
}