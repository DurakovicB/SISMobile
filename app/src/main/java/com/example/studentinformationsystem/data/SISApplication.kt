package com.example.studentinformationsystem.data

import android.app.Application
import com.example.exlabexmobile.data.AppDatabase

class SISApplication: Application() {
    val database: AppDatabase by lazy{AppDatabase.getDatabase(this)}

}