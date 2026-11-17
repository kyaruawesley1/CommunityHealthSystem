package com.example.communityhealthsystem.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.example.communityhealthsystem.data.Appointment
import com.example.communityhealthsystem.databinding.ItemAppointmentBinding

class AppointmentAdapter(private val onDeleteClick: (Appointment) -> Unit) :
    ListAdapter<Appointment, AppointmentAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemAppointmentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemAppointmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appt = getItem(position)
        holder.binding.tvServiceType.text = appt.serviceType
        holder.binding.tvDate.text = "Date: ${appt.date}"
        holder.binding.tvTime.text = "Time: ${appt.time}"
        holder.binding.btnCancel.setOnClickListener { onDeleteClick(appt) }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Appointment>() {
            override fun areItemsTheSame(old: Appointment, new: Appointment) = old.id == new.id
            override fun areContentsTheSame(old: Appointment, new: Appointment) = old == new
        }
    }
}