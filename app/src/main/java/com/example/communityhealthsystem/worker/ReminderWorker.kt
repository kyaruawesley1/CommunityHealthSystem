package com.example.communityhealthsystem.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class ReminderWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val service = inputData.getString("SERVICE_NAME") ?: "Service"
        Log.d("ReminderWorker", "SUCCESS: Background reminder scheduled for $service")
        return Result.success()
    }
}