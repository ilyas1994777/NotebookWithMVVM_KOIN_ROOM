package com.example.notebook.view.view_main_windom.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.Singleton
import com.example.notebook.databinding.ItemMainWindomRecyclerBinding
import com.example.notebook.view.view_edit_description.ViewEditDescription

abstract class AdapterNoteBook(private var itemList : ArrayList<DataNoteBook>) : RecyclerView.Adapter<AdapterNoteBook.HolderNoteBook>() {

    abstract fun deletePosition(position: Int)

    class HolderNoteBook(val itemMainWindomRecycler : ItemMainWindomRecyclerBinding) : RecyclerView.ViewHolder(itemMainWindomRecycler.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HolderNoteBook(
        ItemMainWindomRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))


    override fun onBindViewHolder(holder: HolderNoteBook, position: Int) {
        holder.itemMainWindomRecycler.textViewTitle.text = itemList[position].title
        holder.itemMainWindomRecycler.textViewDescription.text = itemList[position].description
        holder.itemMainWindomRecycler.deletePosition.setOnClickListener {
            deletePosition(position)
        }

        holder.itemView.setOnClickListener {
            var bundle = Bundle()
            bundle.putSerializable("DATA", itemList[position])
            var viewEdit = ViewEditDescription()
            viewEdit.arguments = bundle
            Singleton.switchFragment(viewEdit)
        }


    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}