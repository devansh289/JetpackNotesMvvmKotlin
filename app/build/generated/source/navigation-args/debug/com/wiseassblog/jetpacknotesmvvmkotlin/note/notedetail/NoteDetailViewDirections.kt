package com.wiseassblog.jetpacknotesmvvmkotlin.note.notedetail

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.wiseassblog.jetpacknotesmvvmkotlin.R

class NoteDetailViewDirections private constructor() {
    companion object {
        fun actionNoteDetailView3ToNoteListView2(): NavDirections =
                ActionOnlyNavDirections(R.id.action_noteDetailView3_to_noteListView2)
    }
}
