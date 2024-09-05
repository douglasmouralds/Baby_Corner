package com.example.babycorner.Schedule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(navController: NavController, viewModel: EventViewModel = viewModel()) {
    val events by viewModel.events.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("event/0") // Navegar para a tela de criação/edição de evento
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Event")
            }
        },
        topBar = {
            TopAppBar(title = { Text("Events") })
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events) { event ->
                EventListItem(event, navController, viewModel)
            }
        }
    }
}

@Composable
fun EventListItem(event: Event, navController: NavController, viewModel: EventViewModel) {
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                navController.navigate("event/${event.id}") // Navegar para a tela de detalhes do evento
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.titleMedium)
            Text(text = event.description, style = MaterialTheme.typography.titleSmall)
            Text(text = Date(event.dateTime).toString(), style = MaterialTheme.typography.titleLarge)
            Row(horizontalArrangement = Arrangement.End) {
                IconButton(onClick = {
                    scope.launch {
                        viewModel.deleteEvent(event.id)
                    }
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}