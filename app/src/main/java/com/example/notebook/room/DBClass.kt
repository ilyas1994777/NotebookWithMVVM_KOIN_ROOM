package com.example.notebook.room

import android.content.Context
import androidx.room.Room

class DBClass {

    fun roomDataBaseBuilder(applicationContext: Context) : NoteBookDataBase.NoteBook{
        val db = Room.databaseBuilder(applicationContext, NoteBookDataBase.NoteBook::class.java, "notebook_database").build()
        return db
    }
}