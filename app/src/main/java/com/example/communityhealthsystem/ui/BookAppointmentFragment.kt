package com.example.communityhealthsystem.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.work.*
import com.example.communityhealthsystem.R
import com.example.communityhealthsystem.data.Appointment
import com.example.communityhealthsystem.databinding.FragmentBookAppointmentBinding
import com.example.communityhealthsystem.viewmodel.HealthViewModel
import com.example.communityhealthsystem.worker.ReminderWorker
import java.util.concurrent.TimeUnit

class BookAppointmentFragment : Fragment(R.layout.fragment_book_appointment) {
    private lateinit var binding: FragmentBookAppointmentBinding
    private val viewModel: HealthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBookAppointmentBinding.bind(view)

        val services = arrayOf("Health Education", "Maternal/Child Wellness", "Fitness Tracking")
        binding.spinnerServices.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, services)

        binding.btnSaveBooking.setOnClickListener {
            val service = binding.spinnerServices.selectedItem.toString()
            val date = binding.etBookingDate.text.toString().trim()
            val time = binding.etBookingTime.text.toString().trim()

            if (date.isEmpty() || time.isEmpty()) return@setOnClickListener

            viewModel.addAppointment(
                Appointment(patientId = viewModel.currentUserId, serviceType = service, date = date, time = time)
            )

            val request = OneTimeWorkRequestBuilder<ReminderWorker>()
                .setInputData(workDataOf("SERVICE_NAME" to service))
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(requireContext()).enqueue(request)

            findNavController().navigateUp()
        }
    }
}