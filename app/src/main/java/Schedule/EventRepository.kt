package com.example.babycorner.Schedule

import kotlinx.coroutines.flow.Flow

class EventRepository(private val eventDao: EventDao) {
    fun getEvents(): Flow<List<Event>> = eventDao.getEvents()
    suspend fun addEvent(event: Event) = eventDao.insert(event)
    suspend fun updateEvent(event: Event) = eventDao.update(event)
    suspend fun deleteEvent(id: Int) {
        val event = eventDao.getEventById(id) // Método fictício para obter o evento pelo ID
        event?.let { eventDao.delete(it) }
    }
}