package com.wiseassblog.jetpacknotesmvvmkotlin.note.notedetail

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

data class NoteDetailViewArgs(val nodeID: String) : NavArgs {
    fun toBundle(): Bundle {
        val result = Bundle()
        result.putString("nodeID", this.nodeID)
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): NoteDetailViewArgs {
            bundle.setClassLoader(NoteDetailViewArgs::class.java.classLoader)
            val __nodeID : String?
            if (bundle.containsKey("nodeID")) {
                __nodeID = bundle.getString("nodeID")
                if (__nodeID == null) {
                    throw IllegalArgumentException("Argument \"nodeID\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"nodeID\" is missing and does not have an android:defaultValue")
            }
            return NoteDetailViewArgs(__nodeID)
        }
    }
}
