package com.example.notebook.view.view_main_windom

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notebook.R
import com.example.notebook.Singleton
import com.example.notebook.databinding.ViewMainWindomBinding
import com.example.notebook.room.DBClass
import com.example.notebook.room.DataClassNoteBookCreateTable
import com.example.notebook.room.InterfaceNoteBookDao
import com.example.notebook.room.NoteBookDataBase
import com.example.notebook.view.view_edit_description.ViewModelEditDescription
import com.example.notebook.view.view_main_windom.adapter.AdapterNoteBook
import com.example.notebook.view.view_main_windom.adapter.DataNoteBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject


class ViewMainWindom : Fragment() {

   private var binding : ViewMainWindomBinding? = null
   private val viewModel by inject<ViewModelMainWindom>()
    private var interfaceDAO : InterfaceNoteBookDao? = null
    private var list = ArrayList<DataNoteBook>()
    private var mHandler = Handler(Looper.getMainLooper())
    private val dbClass by inject<DBClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ViewMainWindomBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        interfaceDAO = Singleton.roomDataBaseBuilder(requireContext()).noteBookDao()
        interfaceDAO = dbClass.roomDataBaseBuilder(requireContext()).noteBookDao()
        var adapter = object : AdapterNoteBook(list){

            override fun deletePosition(position: Int) {
                CoroutineScope(Dispatchers.Main).launch{
                    val o = list[position]
                    interfaceDAO!!.deleteById(o.id)
                    mHandler.post(Runnable {
                        if (list.count() != 0) {
                            list.removeAt(position)
                            o.id
                            notifyItemRemoved(position)
                        }
                        })

                }
            }

        }


        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){

                for (i in interfaceDAO!!.getAllNotebook_table()){
                    list.add(DataNoteBook(i.id, i.title, i.description))
                }
            }



            binding?.recyclerView!!.layoutManager = GridLayoutManager(context, 3)
            binding?.recyclerView!!.adapter = adapter
            viewModel.recyclerView = binding!!.recyclerView
        }





    }
}