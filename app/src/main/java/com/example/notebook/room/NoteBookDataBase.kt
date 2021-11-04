package com.example.notebook.room

import androidx.room.Database
import androidx.room.RoomDatabase

class NoteBookDataBase {

    @Database(entities = [DataClassNoteBookCreateTable::class], version = 1)
    abstract class NoteBook : RoomDatabase(){
        abstract fun noteBookDao() : InterfaceNoteBookDao
    }
}