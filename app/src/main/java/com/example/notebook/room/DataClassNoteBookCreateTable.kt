package com.example.notebook.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notebook_table")
data class DataClassNoteBookCreateTable(

    @PrimaryKey(autoGenerate = true)
    var id : Int = 1,

    var title : String,

    var description : String
)