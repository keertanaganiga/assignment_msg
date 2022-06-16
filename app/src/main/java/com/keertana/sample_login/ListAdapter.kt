package com.keertana.sample_login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(val context:Context,val list:ArrayList<Entry>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View=LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false)
        val api=view.findViewById<TextView>(R.id.api)
        val description=view.findViewById<TextView>(R.id.description)
        val category=view.findViewById<TextView>(R.id.category)

        api.text=list[position].API.toString()
        description.text=list[position].Description.toString()
        category.text=list[position].Category.toString()

        return view

    }
}