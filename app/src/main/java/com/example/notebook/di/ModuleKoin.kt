package com.example.notebook.di

import com.example.notebook.room.DBClass
import com.example.notebook.view.view_edit_description.ViewEditDescription
import com.example.notebook.view.view_edit_description.ViewModelEditDescription
import com.example.notebook.view.view_main_windom.ViewModelMainWindom
import org.koin.dsl.module


val mainWindomModule = module {
    factory { ViewModelMainWindom() }
}

val editDescriptionModule = module {
    factory { ViewModelEditDescription() }
}

val DBClassModule = module {
    single { DBClass() }
}