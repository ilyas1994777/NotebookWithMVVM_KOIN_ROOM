package com.example.notebook.view.view_edit_description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notebook.R
import com.example.notebook.Singleton
import com.example.notebook.databinding.ViewEditDescriptionBinding
import com.example.notebook.room.DBClass
import com.example.notebook.view.view_main_windom.adapter.DataNoteBook
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.inject


class ViewEditDescription : Fragment() {

    private var binding : ViewEditDescriptionBinding? = null
    private val viewModel by inject<ViewModelEditDescription>()
    private val dbClwass by inject<DBClass>()

    var flag = false
        set(value) {
            field = value
            if (flag){

            }

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ViewEditDescriptionBinding.inflate(inflater, container, false)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.db = dbClwass
        viewModel.data = (arguments?.getSerializable("DATA") as DataNoteBook?)

    }
}