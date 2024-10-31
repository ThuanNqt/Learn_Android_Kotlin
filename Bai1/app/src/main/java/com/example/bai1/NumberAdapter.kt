package com.example.bai1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(private val numbers: List<Int>) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNumber: TextView = itemView.findViewById(R.id.textViewNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textViewNumber.text = numbers[position].toString()
    }

    override fun getItemCount(): Int {
        return numbers.size
    }
}
