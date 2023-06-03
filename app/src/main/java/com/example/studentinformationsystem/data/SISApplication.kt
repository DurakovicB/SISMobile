package com.example.studentinformationsystem.data

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.exlabexmobile.data.AppDatabase

class SISApplication: Application() {
    val database: AppDatabase by lazy{AppDatabase.getDatabase(this)}
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
    }
}