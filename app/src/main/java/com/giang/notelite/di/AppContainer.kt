package com.giang.notelite.di

import android.content.Context
import com.giang.notelite.data.local.NoteDatabase
import com.giang.notelite.data.repository.NoteRepository


class AppContainer(context: Context) {
    private val database = NoteDatabase.getInstance(context)
    val noteRepository: NoteRepository by lazy { NoteRepository(database.noteDao()) }
}
