package com.example.communityhealthsystem.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.communityhealthsystem.R
import com.example.communityhealthsystem.databinding.FragmentDashboardBinding
import com.example.communityhealthsystem.viewmodel.HealthViewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: HealthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)

        val adapter = AppointmentAdapter {
            viewModel.deleteAppointment(it)
            Toast.makeText(requireContext(), "Appointment Canceled", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewAppointments.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewAppointments.adapter = adapter

        viewModel.getMyAppointments().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.fabAddAppointment.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_book)
        }
    }
}