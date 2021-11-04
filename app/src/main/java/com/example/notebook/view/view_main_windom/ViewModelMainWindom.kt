package com.example.notebook.view.view_main_windom

import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.BaseObservable
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.Singleton
import com.example.notebook.view.view_edit_description.ViewEditDescription
import com.example.notebook.view.view_edit_description.ViewModelEditDescription
import com.example.notebook.view.view_main_windom.adapter.AdapterNoteBook
import com.example.notebook.view.view_main_windom.adapter.DataNoteBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelMainWindom(): BaseObservable() {


    var recyclerView : RecyclerView? = null


    fun clickCreateNotebook(){

        Singleton.switchFragment(ViewEditDescription())
    }
}