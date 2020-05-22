package com.wiseassblog.jetpacknotesmvvmkotlin.note.notelist

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_note_demo.*

class NoteActivityDemo : AppCompatActivity() {

    private lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        nav = Navigation.findNavController(this, R.id.fragment_nav)
    }
}