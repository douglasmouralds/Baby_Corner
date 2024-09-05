package com.example.babycorner.Schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventViewModel(private val repository: EventRepository) : ViewModel() {
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    init {
        viewModelScope.launch {
            repository.getEvents().collect {
                _events.value = it
            }
        }
    }

    fun getEvent(id: Int): Event? {
        return _events.value.find { it.id == id }
    }

    fun addEvent(event: Event) {
        viewModelScope.launch {
            repository.addEvent(event)
        }
    }

    fun updateEvent(event: Event) {
        viewModelScope.launch {
            repository.updateEvent(event)
        }
    }

    fun deleteEvent(id: Int) {
        viewModelScope.launch {
            repository.deleteEvent(id)
        }
    }

    // Gera um novo ID baseado no maior ID existente
    fun generateNewEventId(): Int {
        return (_events.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}
