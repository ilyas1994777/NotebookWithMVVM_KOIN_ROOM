package com.example.notebook

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.notebook.room.NoteBookDataBase

object Singleton {

    var mainActivity : MainActivity? = null

    fun switchFragment(ft : Fragment){
        mainActivity!!.supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ft)
            commit()
        }
    }

//    fun roomDataBaseBuilder(applicationContext: Context) : NoteBookDataBase.NoteBook{
//        val db = Room.databaseBuilder(applicationContext, NoteBookDataBase.NoteBook::class.java, "notebook_database").build()
//    return db
//    }
}