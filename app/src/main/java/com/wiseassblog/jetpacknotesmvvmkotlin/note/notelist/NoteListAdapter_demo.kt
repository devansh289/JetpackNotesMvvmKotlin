package com.wiseassblog.jetpacknotesmvvmkotlin.note.notelist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wiseassblog.jetpacknotesmvvmkotlin.R
import com.wiseassblog.jetpacknotesmvvmkotlin.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteListAdapter_demo(val event:MutableLiveData<NoteListEvent>): ListAdapter<Note, NoteListAdapter_demo.NoteViewHolder>(NoteDiffUtilCallback()){
    class NoteViewHolder(root: View): RecyclerView.ViewHolder(root){
        var content: TextView = root.lbl_message
        var date: TextView = root.lbl_date_and_time

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

