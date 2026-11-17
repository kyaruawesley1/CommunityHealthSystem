package com.example.communityhealthsystem.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.communityhealthsystem.data.*
import com.example.communityhealthsystem.repository.HealthRepository
import kotlinx.coroutines.launch

class HealthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = HealthRepository(DatabaseHelper(application))
    var currentUserId: Int = -1

    private val _appointments = MutableLiveData<List<Appointment>>()

    fun register(user: User) = viewModelScope.launch { repository.register(user) }

    suspend fun login(email: String, pin: String): User? = repository.login(email, pin)

    fun addAppointment(appointment: Appointment) = viewModelScope.launch {
        repository.addAppointment(appointment)
        refreshAppointments()
    }

    fun getMyAppointments(): LiveData<List<Appointment>> {
        refreshAppointments()
        return _appointments
    }

    private fun refreshAppointments() = viewModelScope.launch {
        if (currentUserId != -1) {
            _appointments.value = repository.getAppointments(currentUserId)
        }
    }

    fun deleteAppointment(appointment: Appointment) = viewModelScope.launch {
        repository.deleteAppointment(appointment.id)
        refreshAppointments()
    }

    fun updateAppointment(id: Int, newDate: String, newTime: String) = viewModelScope.launch {
        repository.updateAppointment(id, newDate, newTime)
        refreshAppointments() // Automatically refreshes the Dashboard list
    }

}