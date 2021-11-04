package com.example.notebook.di

import android.app.Application
import org.koin.core.context.startKoin

class BaseKoin: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    mainWindomModule,
                    editDescriptionModule,
                    DBClassModule
                )
            )
        }
    }
}