package com.example.babycorner.Schedule

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

object AppModule {
    fun provideEventViewModel(context: Context, owner: ViewModelStoreOwner): EventViewModel {
        val eventDao = EventDatabase.getDatabase(context).eventDao()
        val repository = EventRepository(eventDao)
        return ViewModelProvider(owner, EventViewModelFactory(repository)).get(EventViewModel::class.java)
    }
}