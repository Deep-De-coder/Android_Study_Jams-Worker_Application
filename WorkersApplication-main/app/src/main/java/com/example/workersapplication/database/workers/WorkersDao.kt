package com.example.workersapplication.database.workers

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkersDao {

    @Query("SELECT * FROM workers")
    fun getAll(): LiveData<List<Workers>>

}