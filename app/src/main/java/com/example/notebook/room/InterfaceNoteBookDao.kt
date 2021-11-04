package com.example.notebook.room

import androidx.room.*

@Dao
interface InterfaceNoteBookDao {

    @Query("INSERT INTO notebook_table (title, description) VALUES(:title, :description)")
    suspend fun insertNotebook(title: String, description: String)


    @Query("SELECT * FROM notebook_table")
    suspend fun getAllNotebook_table() : List<DataClassNoteBookCreateTable>

    @Update
    suspend fun updateNoteBook(noteBookCreateTable: DataClassNoteBookCreateTable)

    @Query("DELETE FROM notebook_table WHERE id = :id")
    suspend fun deleteById(id : Int)

    @Query("UPDATE notebook_table SET title = :title, description = :description WHERE id =:id")
    suspend fun updateById(id: Int, title: String, description: String)

}