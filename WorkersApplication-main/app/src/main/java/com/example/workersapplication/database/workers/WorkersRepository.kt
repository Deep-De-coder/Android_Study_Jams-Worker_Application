package com.example.workersapplication.database.workers

import androidx.lifecycle.LiveData

class WorkersRepository(private val workersDao: WorkersDao) {

    val readAllData: LiveData<List<Workers>> = workersDao.getAll()

}