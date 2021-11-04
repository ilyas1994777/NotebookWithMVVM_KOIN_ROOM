package com.example.notebook.view.view_edit_description

import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import com.example.notebook.Singleton
import com.example.notebook.room.DBClass
import com.example.notebook.room.DataClassNoteBookCreateTable
import com.example.notebook.room.NoteBookDataBase
import com.example.notebook.view.view_main_windom.ViewMainWindom
import com.example.notebook.view.view_main_windom.adapter.DataNoteBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.inject

class ViewModelEditDescription: BaseObservable() {
    var db : DBClass? = null
    var data: DataNoteBook? = null
        set(value) {
            if (value != null) {
                field = value
                editTitle = value.title
                description = value.description
            }
        }


//    private var db = Singleton.roomDataBaseBuilder(Singleton.mainActivity!!.baseContext)


    var editTitle = ""
    set(value) {
        field = value
        notifyChange()
    }
    var description = ""
    set(value) {
        field = value
        notifyChange()
    }


    fun saveDescription() {

        if (editTitle.isNotEmpty() && description.isNotEmpty()) {
            CoroutineScope(Dispatchers.Main).launch {
                withContext(Dispatchers.IO) {
                    if (data != null) {
//                        db.noteBookDao().updateById(data!!.id, editTitle, description)
                        db!!.roomDataBaseBuilder(Singleton.mainActivity!!).noteBookDao().updateById(data!!.id, editTitle, description)
                    } else {
//                        db.noteBookDao().insertNotebook(title = editTitle, description = description)
                        db!!.roomDataBaseBuilder(Singleton.mainActivity!!).noteBookDao().insertNotebook(title = editTitle, description = description)
                    }
                }
                Singleton.switchFragment(ViewMainWindom())
            }
        } else Toast.makeText(Singleton.mainActivity, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
    }
}