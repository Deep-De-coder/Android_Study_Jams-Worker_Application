package com.example.workersapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workersapplication.database.AppDatabase
import com.example.workersapplication.database.workers.Workers
import com.example.workersapplication.database.workers.WorkersDao
import com.example.workersapplication.database.workers.WorkersRepository
import kotlinx.coroutines.flow.Flow


class WorkersViewModel(application: Application): AndroidViewModel(application){

    val readAllData: LiveData<List<Workers>>
    private val repository: WorkersRepository

    init {
        val workersDao = AppDatabase.getDatabase(application).workersDao()
        repository = WorkersRepository(workersDao)
        readAllData = repository.readAllData
    }
}
/*class WorkersViewModel(private val workersDao : WorkersDao): ViewModel() {

    fun allWorkers(): Flow<List<Workers>> = workersDao.getAll()

}*/
/*
class WorkersViewModelFactory(
    private val workersDao: WorkersDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorkersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WorkersViewModel(workersDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/
