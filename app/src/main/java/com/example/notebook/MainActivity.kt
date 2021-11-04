package com.example.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notebook.view.view_main_windom.ViewMainWindom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Singleton.mainActivity = this

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.emptyFragment, ViewMainWindom())
            commit()
        }
    }
}