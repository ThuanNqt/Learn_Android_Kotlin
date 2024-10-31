package com.example.bai2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bai2.model.Student

class StudentAdapter(private var studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var fullStudentList: List<Student> = ArrayList(studentList) // Dùng để lưu danh sách gốc

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(android.R.id.text1)
        val mssvTextView: TextView = itemView.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.nameTextView.text = student.name
        holder.mssvTextView.text = student.mssv
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    // Hàm để lọc danh sách sinh viên
    fun filter(query: String) {
        studentList = if (query.length > 2) {
            fullStudentList.filter { it.name.contains(query, true) || it.mssv.contains(query, true) }
        } else {
            fullStudentList
        }
        notifyDataSetChanged()
    }
}
