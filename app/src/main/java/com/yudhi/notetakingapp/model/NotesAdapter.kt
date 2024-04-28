package com.yudhi.notetakingapp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudhi.notetakingapp.R

class NotesAdapter (private val notesList: List<notes>, private val listener: (notes) -> Unit)
    : RecyclerView.Adapter<NotesAdapter.ViewHolder>(){
    class ViewHolder (itemView: View, private val listener: (notes) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val judulNotes: TextView = itemView.findViewById(R.id.tv_judul)
        val ringkasanNotes: TextView = itemView.findViewById(R.id.tv_ringkasan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_note, parent, false)
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notes = notesList[position]
        holder.judulNotes.text = notes.noteTitle
        holder.ringkasanNotes.text = notes.noteContent
    }
}